package com.github.jmodel.adapter.impl.mapping;

import java.util.SortedMap;

import com.github.jmodel.adapter.api.mapping.MapperAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.mapping.MapperAdapterFactory;

/**
 * Mapper adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class MapperAdapterFactoryImpl extends MapperAdapterFactory {

	@Override
	protected void createMapperAdapters(SortedMap<String, MapperAdapter> map) {
		map.put(AdapterImplTerms.JMODEL_MAPPER, new JModelMapperAdapter());
	}

}
