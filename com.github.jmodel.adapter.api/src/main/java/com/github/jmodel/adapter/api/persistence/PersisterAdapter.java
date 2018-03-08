package com.github.jmodel.adapter.api.persistence;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.Adapter;

/**
 * Persister adapter
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class PersisterAdapter extends Adapter {

	@Override
	public String getItemId() {
		return AdapterTerms.PERSISTER;
	}

	public abstract <S, T> Long insert(S session, Action<?, ?, ?> action, String json, Class<T> clz)
			throws AdapterException;

	public abstract <S, T> Long insertObject(S session, Action<?, ?, ?> action, T object) throws AdapterException;

}
