package com.github.jmodel.adapter.impl.cache;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.cache.CacherAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.cache.CacherAdapterFactory;

/**
 * Cacher adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class CacherAdapterFactoryImpl implements CacherAdapterFactory {

	private SortedMap<String, CacherAdapter> map;

	public CacherAdapterFactoryImpl() {
		map = new TreeMap<String, CacherAdapter>();
		map.put(AdapterImplTerms.JCS_CACHER, new JCSCacherAdapter());
	}

	@Override
	public CacherAdapter getAdapter(String adapterId) {
		return map.get(adapterId);
	}

}
