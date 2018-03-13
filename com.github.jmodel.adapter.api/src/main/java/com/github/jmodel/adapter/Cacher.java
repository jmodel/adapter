package com.github.jmodel.adapter;

import com.github.jmodel.adapter.api.Facade;
import com.github.jmodel.adapter.api.cache.CacherAdapter;
import com.github.jmodel.adapter.api.cache.CacherAdapterFactoryService;
import com.github.jmodel.adapter.spi.Term;

/**
 * Simple cache facade.
 * <p>
 * 
 * @author jianni@hotmail.com
 * @see com.github.jmodel.adapter.api.Facade
 *
 */
public final class Cacher extends Facade<CacherAdapter> {

	/**
	 * Cacher adapter factory service
	 */
	private final static CacherAdapterFactoryService _cacher_sp = CacherAdapterFactoryService.getInstance();

	private Cacher(CacherAdapter cacherAdapter) {
		this.adapter = cacherAdapter;
	}

	//

	public static Cacher getCacher() {
		return getCacher(null);
	}

	public static Cacher getCacher(Term adapterTerm) {
		CacherAdapter cacherAdapter = _cacher_sp
				.getAdapter(getTermText(tfs.getTerm(AdapterTerms.CACHER_ADAPTER), adapterTerm));
		Cacher cacher = fm.getFacade(cacherAdapter);
		if (cacher != null) {
			return cacher;
		}

		synchronized (fm) {
			if (cacher == null) {
				cacher = new Cacher(cacherAdapter);
				fm.addFacade(cacher);
			}
			return cacher;
		}
	}

	//

	public <T> T get(String region, String key) {
		return adapter.get(region, key);
	}

	public <T> void put(String region, String key, T value) {
		adapter.put(region, key, value);
	}

}
