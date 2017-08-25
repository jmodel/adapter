package com.github.jmodel.adapter.api.persistence;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.api.Adapter;

/**
 * Persister adapter
 * 
 * @author jianni@hotmail.com
 *
 */
public interface PersisterAdapter extends Adapter {

	public <S, T> Long insert(S session, String persistenceName, String json, Class<T> clz) throws AdapterException;

	public <S, T> Long insertObject(S session, String persistenceName, T object) throws AdapterException;

}
