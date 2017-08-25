package com.github.jmodel.adapter;

import java.util.Map;

import com.github.jmodel.adapter.api.AdapterFactoryService;
import com.github.jmodel.adapter.api.mapping.MapperAdapter;

/**
 * Public API for mapping.
 * 
 * @author jianni@hotmail.com
 *
 */
public class Mapper {

	private final static MapperAdapter mapperAdapter = AdapterFactoryService.getInstance()
			.getAdapter(MapperAdapter.class);

	public static <T> T convert(Object sourceObj, String mappingURI, Map<String, Object> argsMap, Class<T> valueType)
			throws AdapterException {

		checkAdapter();

		return mapperAdapter.convert(sourceObj, mappingURI, argsMap, valueType);
	}

	public static <T> T convert(Object sourceObj, String mappingURI, Class<T> valueType) throws AdapterException {

		checkAdapter();
		
		return mapperAdapter.convert(sourceObj, mappingURI, valueType);
	}

	private static void checkAdapter() {
		if (mapperAdapter == null) {
			throw new RuntimeException("Mapper adapter is not found, please check service provider configuration");
		}
	}
}
