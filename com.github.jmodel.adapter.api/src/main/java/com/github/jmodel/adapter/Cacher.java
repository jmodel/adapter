package com.github.jmodel.adapter;

import com.github.jmodel.adapter.api.Facade;
import com.github.jmodel.adapter.api.Term;
import com.github.jmodel.adapter.api.cache.CacherAdapter;
import com.github.jmodel.adapter.api.cache.CacherAdapterFactoryService;

/**
 * Simple cache facade.
 * <p>
 * 
 * @author jianni@hotmail.com
 * @see com.github.jmodel.adapter.api.Facade
 *
 */
public final class Cacher extends Facade {

	/**
	 * Cacher adapter factory service
	 */
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

	public static Cacher getCacher(Term t) {
		String cacherAdapterId = getAdapterId(AdapterTerms.CACHER, t);
		Cacher cacher = fm.getFacade(cacherAdapterId);
		if (cacher != null) {
			return cacher;
		}

		synchronized (fm) {
			if (cacher == null) {
				cacher = new Cacher(cacherAdapterId, _cacher_sp.getAdapter(cacherAdapterId));
				fm.addFacade(cacher);
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
