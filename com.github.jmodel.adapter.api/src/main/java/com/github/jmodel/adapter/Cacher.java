package com.github.jmodel.adapter;

import com.github.jmodel.adapter.api.cache.CacherAdapter;
import com.github.jmodel.adapter.api.cache.CacherAdapterFactoryService;

/**
 * Public API for cache.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class Cacher extends Facade {

	private final static CacherAdapterFactoryService _cacher_sp = CacherAdapterFactoryService.getInstance();

	private CacherAdapter cacherAdapter;

	private Cacher(String id, CacherAdapter cacherAdapter) {
		if (cacherAdapter == null) {
			throw new RuntimeException("Cacher adapter is not found.");
		}
		this.id = id;
		this.cacherAdapter = cacherAdapter;
	}

	//

	public static Cacher getCacher() {
		return getCacher(null);
	}

	public static Cacher getCacher(String name) {
		String cacherAdapterId = getAdapterId(AdapterTerms.CACHER, name);
		Cacher cacher = facadeManager.getFacade(cacherAdapterId);
		if (cacher != null) {
			return cacher;
		}

		synchronized (facadeManager) {
			if (cacher == null) {
				cacher = new Cacher(cacherAdapterId, _cacher_sp.getAdapter(cacherAdapterId));
				facadeManager.addFacade(cacher);
			}
			return cacher;
		}
	}

	//

	public <T> T get(String region, String key) {
		return cacherAdapter.get(region, key);
	}

	public <T> void put(String region, String key, T value) {
		cacherAdapter.put(region, key, value);
	}

}
