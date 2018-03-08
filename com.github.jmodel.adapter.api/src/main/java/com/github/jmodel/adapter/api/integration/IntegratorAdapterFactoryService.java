package com.github.jmodel.adapter.api.integration;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.github.jmodel.adapter.spi.integration.IntegratorAdapterFactory;

/**
 * Integrator adapter factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
public class IntegratorAdapterFactoryService {

	private static IntegratorAdapterFactoryService service;

	private ServiceLoader<IntegratorAdapterFactory> loader;

	private IntegratorAdapterFactoryService() {
		loader = ServiceLoader.load(IntegratorAdapterFactory.class);
	}

	public static synchronized IntegratorAdapterFactoryService getInstance() {
		if (service == null) {
			service = new IntegratorAdapterFactoryService();
		}
		return service;
	}

	public IntegratorAdapter getAdapter(String integratorAdapterId) {

		IntegratorAdapter integratorAdapter = null;

		Iterator<IntegratorAdapterFactory> integratorAdapterFactorys = loader.iterator();
		while (integratorAdapter == null && integratorAdapterFactorys.hasNext()) {
			IntegratorAdapterFactory integratorAdapterFactory = integratorAdapterFactorys.next();
			integratorAdapter = integratorAdapterFactory.getAdapter(integratorAdapterId);
		}
		return integratorAdapter;
	}

}
