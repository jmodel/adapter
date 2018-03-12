package com.github.jmodel.adapter.api.mapping;

import java.util.Map;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.Adapter;

/**
 * Mapper adatper
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class MapperAdapter extends Adapter {

	@Override
	public String getItemId() {
		return AdapterTerms.MAPPER.toString();
	}

	public abstract <T> T convert(Object sourceObj, String mappingURI, Map<String, Object> argsMap, Class<T> valueType)
			throws AdapterException;

	public abstract <T> T convert(Object sourceObj, String mappingURI, Class<T> valueType) throws AdapterException;
}
