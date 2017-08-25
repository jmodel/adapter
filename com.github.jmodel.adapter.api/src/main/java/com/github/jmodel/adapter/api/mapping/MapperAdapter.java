package com.github.jmodel.adapter.api.mapping;

import java.util.Map;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.api.Adapter;

/**
 * Mapper adatper
 * 
 * @author jianni@hotmail.com
 *
 */
public interface MapperAdapter extends Adapter {

	public <T> T convert(Object sourceObj, String mappingURI, Map<String, Object> argsMap, Class<T> valueType)
			throws AdapterException;

	public <T> T convert(Object sourceObj, String mappingURI, Class<T> valueType) throws AdapterException;
}
