package com.github.jmodel.adapter.spi.mapping;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.mapping.MapperAdapter;
import com.github.jmodel.adapter.spi.Factory;

/**
 * Mapper adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class MapperAdapterFactory extends Factory<MapperAdapter> {

	protected final void init() {
		map = new TreeMap<String, MapperAdapter>();
		createMapperAdapters(map);
	}

	protected abstract void createMapperAdapters(SortedMap<String, MapperAdapter> map);
}
