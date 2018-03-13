package com.github.jmodel.adapter.impl.persistence;

import java.util.SortedMap;

import com.github.jmodel.adapter.api.persistence.PersisterAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.persistence.PersisterAdapterFactory;

/**
 * Persister adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class PersisterAdapterFactoryImpl extends PersisterAdapterFactory {

	@Override
	protected void createPersisterAdapters(SortedMap<String, PersisterAdapter> map) {
		map.put(AdapterImplTerms.MYBATIS_PERSISTER, new PersisterAdapterImpl());
	}

}
