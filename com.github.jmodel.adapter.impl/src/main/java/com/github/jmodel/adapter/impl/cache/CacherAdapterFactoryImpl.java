package com.github.jmodel.adapter.impl.cache;

import java.util.SortedMap;

import com.github.jmodel.adapter.api.cache.CacherAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.cache.CacherAdapterFactory;

/**
 * Cacher adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class CacherAdapterFactoryImpl extends CacherAdapterFactory {

	@Override
	protected void createCacherAdapters(SortedMap<String, CacherAdapter> map) {
		map.put(AdapterImplTerms.JCS_CACHER, new JCSCacherAdapter());
	}
}
