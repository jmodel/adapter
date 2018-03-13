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
public final class CacherAdapterFactoryService {

	private static CacherAdapterFactoryService service;

	private ServiceLoader<CacherAdapterFactory> loader;

	private CacherAdapterFactoryService() {
		loader = ServiceLoader.load(CacherAdapterFactory.class);
	}

	public static CacherAdapterFactoryService getInstance() {
		if (service != null) {
			return service;
		}

		synchronized (CacherAdapterFactoryService.class) {
			if (service == null) {
				service = new CacherAdapterFactoryService();
			}
			return service;
		}
	}

	public CacherAdapter getAdapter(String text) {

		CacherAdapter cacherAdapter = null;
		Iterator<CacherAdapterFactory> cacherAdapterFactorys = loader.iterator();
		while (cacherAdapter == null && cacherAdapterFactorys.hasNext()) {
			CacherAdapterFactory cacherAdapterFactory = cacherAdapterFactorys.next();
			cacherAdapter = cacherAdapterFactory.getAdapter(text);
		}
		return cacherAdapter;
	}

}
