package com.github.jmodel.adapter.spi.cache;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.cache.CacherAdapter;
import com.github.jmodel.adapter.spi.AdapterFactory;

/**
 * Cacher adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class CacherAdapterFactory extends AdapterFactory<CacherAdapter> {

	protected final void init() {
		map = new TreeMap<String, CacherAdapter>();
		createCacherAdapters(map);
	}

	protected abstract void createCacherAdapters(SortedMap<String, CacherAdapter> map);
}
