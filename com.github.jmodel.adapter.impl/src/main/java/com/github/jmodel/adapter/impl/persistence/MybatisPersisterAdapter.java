package com.github.jmodel.adapter.impl.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.adapter.api.persistence.PersisterAdapter;

/**
 * Adapter to use database.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class MybatisPersisterAdapter extends PersisterAdapter {

	private ObjectMapper objectMapper = new ObjectMapper();

	public MybatisPersisterAdapter() {

	}

	@Override
	public <S, T> Long insert(S session, Action<?, ?, ?> action, String json, Class<T> clz) throws AdapterException {

		try {
			T obj = objectMapper.readValue(json, clz);

			@SuppressWarnings("unchecked")
			Action<S, T, Long> crudFunction = (Action<S, T, Long>) action;
			return crudFunction.apply(session, obj);
		} catch (Exception e) {
			throw new AdapterException("Failed to insert", e);
		}
	}

	@Override
	public <S, T> Long insertObject(S session, Action<?, ?, ?> action, T obj) throws AdapterException {
		try {

			@SuppressWarnings("unchecked")
			Action<S, T, Long> crudFunction = (Action<S, T, Long>) action;
			return crudFunction.apply(session, obj);
		} catch (Exception e) {
			throw new AdapterException("Failed to insert object", e);
		}
	}

}
