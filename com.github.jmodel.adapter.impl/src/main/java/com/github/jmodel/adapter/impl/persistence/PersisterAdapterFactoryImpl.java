package com.github.jmodel.adapter.impl.persistence;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.persistence.PersisterAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.persistence.PersisterAdapterFactory;

/**
 * Persister adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class PersisterAdapterFactoryImpl implements PersisterAdapterFactory {

	private SortedMap<String, PersisterAdapter> map;

	public PersisterAdapterFactoryImpl() {
		map = new TreeMap<String, PersisterAdapter>();
		map.put(AdapterImplTerms.MYBATIS_PERSISTER, new PersisterAdapterImpl());
	}

	@Override
	public PersisterAdapter getAdapter(String adapterId) {
		return map.get(adapterId);
	}

}
