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
public class PersisterAdapterFactoryService {

	private static PersisterAdapterFactoryService service;

	private ServiceLoader<PersisterAdapterFactory> loader;

	private PersisterAdapterFactoryService() {
		loader = ServiceLoader.load(PersisterAdapterFactory.class);
	}

	public static synchronized PersisterAdapterFactoryService getInstance() {
		if (service == null) {
			service = new PersisterAdapterFactoryService();
		}
		return service;
	}

	public PersisterAdapter getAdapter(String persisterAdapterId) {

		PersisterAdapter persisterAdapter = null;

		Iterator<PersisterAdapterFactory> persisterAdapterFactorys = loader.iterator();
		while (persisterAdapter == null && persisterAdapterFactorys.hasNext()) {
			PersisterAdapterFactory persisterAdapterFactory = persisterAdapterFactorys.next();
			persisterAdapter = persisterAdapterFactory.getAdapter(persisterAdapterId);
		}
		return persisterAdapter;
	}

}
