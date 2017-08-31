package com.github.jmodel.adapter.impl.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.adapter.api.persistence.CrudFunctionFactoryService;
import com.github.jmodel.adapter.api.persistence.PersisterAdapter;

/**
 * Adapter to use database.
 * 
 * @author jianni@hotmail.com
 *
 */
public class PersistenterAdapterImpl implements PersisterAdapter {

	private ObjectMapper objectMapper = new ObjectMapper();

	public PersistenterAdapterImpl() {

	}

	@Override
	public <S, T> Long insert(S session, String persistenceName, String json, Class<T> clz) throws AdapterException {

		try {
			T obj = objectMapper.readValue(json, clz);
			Action<S, T, Long> crudFunction = CrudFunctionFactoryService.getInstance().getCrudFunction(persistenceName);
			if (crudFunction == null) {

			}
			return crudFunction.apply(session, obj);
		} catch (Exception e) {
			throw new AdapterException("Failed to insert", e);
		}
	}

	@Override
	public <S, T> Long insertObject(S session, String persistenceName, T obj) throws AdapterException {
		try {
			Action<S, T, Long> crudFunction = CrudFunctionFactoryService.getInstance().getCrudFunction(persistenceName);
			return crudFunction.apply(session, obj);
		} catch (Exception e) {
			throw new AdapterException("Failed to insert", e);
		}
	}
}