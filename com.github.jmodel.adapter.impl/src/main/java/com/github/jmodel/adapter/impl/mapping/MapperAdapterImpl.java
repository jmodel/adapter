package com.github.jmodel.adapter.impl.mapping;

import java.util.Map;

import com.github.jmodel.ModelException;
import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.api.mapping.MapperAdapter;
import com.github.jmodel.mapper.ModelMapper;

/**
 * Adapter to use jmodel model mapper.
 * 
 * @author jianni@hotmail.com
 *
 */
public class MapperAdapterImpl implements MapperAdapter {

	@Override
	public <T> T convert(Object sourceObj, String mappingURI, Map<String, Object> argsMap, Class<T> valueType)
			throws AdapterException {

		try {
			return ModelMapper.convert(sourceObj, mappingURI, argsMap, valueType);
		} catch (ModelException e) {
			throw new AdapterException("Failed to do model mapping", e);
		}
	}

	@Override
	public <T> T convert(Object sourceObj, String mappingURI, Class<T> valueType) throws AdapterException {

		try {
			return ModelMapper.convert(sourceObj, mappingURI, valueType);
		} catch (ModelException e) {
			throw new AdapterException("Failed to do model mapping", e);
		}
	}

}
