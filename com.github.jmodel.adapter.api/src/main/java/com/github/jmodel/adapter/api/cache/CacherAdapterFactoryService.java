package com.github.jmodel.adapter.api.cache;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.github.jmodel.adapter.spi.cache.CacherAdapterFactory;

/**
 * Cacher adapter factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
public class CacherAdapterFactoryService {

	private static CacherAdapterFactoryService service;

	private ServiceLoader<CacherAdapterFactory> loader;

	private CacherAdapterFactoryService() {
		loader = ServiceLoader.load(CacherAdapterFactory.class);
	}

	public static synchronized CacherAdapterFactoryService getInstance() {
		if (service == null) {
			service = new CacherAdapterFactoryService();
		}
		return service;
	}

	public CacherAdapter getAdapter(String cacherAdapterId) {

		CacherAdapter cacherAdapter = null;

		Iterator<CacherAdapterFactory> cacherAdapterFactorys = loader.iterator();
		while (cacherAdapter == null && cacherAdapterFactorys.hasNext()) {
			CacherAdapterFactory cacherAdapterFactory = cacherAdapterFactorys.next();
			cacherAdapter = cacherAdapterFactory.getAdapter(cacherAdapterId);
		}
		return cacherAdapter;
	}

}
