package com.github.jmodel.adapter.impl.integration;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.integration.IntegratorAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.integration.IntegratorAdapterFactory;

/**
 * Integrator adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class IntegratorAdapterFactoryImpl implements IntegratorAdapterFactory {

	private SortedMap<String, IntegratorAdapter> map;

	public IntegratorAdapterFactoryImpl() {
		map = new TreeMap<String, IntegratorAdapter>();
		map.put(AdapterImplTerms.INTEGRATION_CLIENT, new IntegratorAdapterImpl());
	}

	@Override
	public IntegratorAdapter getAdapter(String adapterId) {
		return map.get(adapterId);
	}

}
