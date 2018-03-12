package com.github.jmodel.adapter.impl.mapping;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.mapping.MapperAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.mapping.MapperAdapterFactory;

/**
 * Mapper adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class MapperAdapterFactoryImpl implements MapperAdapterFactory {

	private SortedMap<String, MapperAdapter> map;

	public MapperAdapterFactoryImpl() {
		map = new TreeMap<String, MapperAdapter>();
		map.put(AdapterImplTerms.JMODEL_MAPPER.toString(), new MapperAdapterImpl());
	}

	@Override
	public MapperAdapter getAdapter(String adapterId) {
		return map.get(adapterId);
	}

}
