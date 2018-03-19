package com.github.jmodel.adapter.api.persistence;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.github.jmodel.adapter.spi.persistence.PersisterAdapterFactory;

/**
 * Persister adapter factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class PersisterAdapterFactoryService {

	private static PersisterAdapterFactoryService service;

	private ServiceLoader<PersisterAdapterFactory> loader;

	private PersisterAdapterFactoryService() {
		loader = ServiceLoader.load(PersisterAdapterFactory.class);
	}

	public static PersisterAdapterFactoryService getInstance() {
		if (service != null) {
			return service;
		}

		synchronized (PersisterAdapterFactoryService.class) {
			if (service == null) {
				service = new PersisterAdapterFactoryService();
			}
			return service;
		}
	}

	public PersisterAdapter getAdapter(String text) {

		PersisterAdapter persisterAdapter = null;

		Iterator<PersisterAdapterFactory> persisterAdapterFactorys = loader.iterator();
		while (persisterAdapter == null && persisterAdapterFactorys.hasNext()) {
			PersisterAdapterFactory persisterAdapterFactory = persisterAdapterFactorys.next();
			persisterAdapter = persisterAdapterFactory.create(text);
		}
		return persisterAdapter;
	}

}
