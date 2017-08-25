package com.github.jmodel.adapter.api;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.jmodel.adapter.spi.AdapterFactory;

/**
 * Adapter factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
public class AdapterFactoryService {

	/**
	 * JDK Logger
	 */
	private final static Logger logger = Logger.getLogger(AdapterFactoryService.class.getName());

	private static AdapterFactoryService service;

	private ServiceLoader<AdapterFactory> loader;

	private AdapterFactoryService() {
		loader = ServiceLoader.load(AdapterFactory.class);
	}

	public static synchronized AdapterFactoryService getInstance() {
		if (service == null) {
			service = new AdapterFactoryService();
		}
		return service;
	}

	public <T extends Adapter> T getAdapter(Class<T> valueType) {

		T adapter = null;

		try {
			Iterator<AdapterFactory> adapterFactorys = loader.iterator();
			while (adapter == null && adapterFactorys.hasNext()) {
				AdapterFactory adapterFactory = adapterFactorys.next();
				adapter = adapterFactory.getAdapter(valueType);
			}
		} catch (ServiceConfigurationError serviceError) {
			adapter = null;
			serviceError.printStackTrace();
		} catch (Exception e) {
			logger.log(Level.WARNING, e, () -> "Failed to get adapter");
		}
		return adapter;
	}

	public Config getConfig() {

		Config config = null;

		try {
			Iterator<AdapterFactory> adapterFactorys = loader.iterator();
			while (config == null && adapterFactorys.hasNext()) {
				AdapterFactory adapterFactory = adapterFactorys.next();
				config = adapterFactory.getConfig();
			}
		} catch (ServiceConfigurationError serviceError) {
			config = null;
			serviceError.printStackTrace();
		} catch (Exception e) {
			logger.log(Level.WARNING, e, () -> "Failed to get config");
		}
		return config;
	}
}
