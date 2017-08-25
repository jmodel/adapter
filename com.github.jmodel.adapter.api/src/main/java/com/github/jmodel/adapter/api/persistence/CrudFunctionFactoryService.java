package com.github.jmodel.adapter.api.persistence;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.jmodel.adapter.spi.persistence.CrudFunctionFactory;

/**
 * CRUD function factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
public class CrudFunctionFactoryService {

	/**
	 * JDK Logger
	 */
	private final static Logger logger = Logger.getLogger(CrudFunctionFactoryService.class.getName());

	private static CrudFunctionFactoryService service;

	private ServiceLoader<CrudFunctionFactory> loader;

	private CrudFunctionFactoryService() {
		loader = ServiceLoader.load(CrudFunctionFactory.class);
	}

	public static synchronized CrudFunctionFactoryService getInstance() {
		if (service == null) {
			service = new CrudFunctionFactoryService();
		}
		return service;
	}

	public <T extends Action<?, ?, ?>> T getCrudFunction(String persistenceName) {

		T crudFunction = null;

		try {
			Iterator<CrudFunctionFactory> crudFunctionFactorys = loader.iterator();
			while (crudFunction == null && crudFunctionFactorys.hasNext()) {
				CrudFunctionFactory crudFunctionFactory = crudFunctionFactorys.next();
				crudFunction = crudFunctionFactory.getCrudFunction(persistenceName);
			}
		} catch (ServiceConfigurationError serviceError) {
			crudFunction = null;
			serviceError.printStackTrace();
		} catch (Exception e) {
			logger.log(Level.WARNING, e, () -> "Failed to get CRUD function");
		}
		return crudFunction;
	}
}
