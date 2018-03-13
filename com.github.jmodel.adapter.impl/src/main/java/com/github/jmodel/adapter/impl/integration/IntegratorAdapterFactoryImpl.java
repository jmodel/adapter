package com.github.jmodel.adapter.impl.integration;

import java.util.SortedMap;

import com.github.jmodel.adapter.api.integration.IntegratorAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.integration.IntegratorAdapterFactory;

/**
 * Integrator adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class IntegratorAdapterFactoryImpl extends IntegratorAdapterFactory {

	@Override
	protected void createIntegratorAdapters(SortedMap<String, IntegratorAdapter> map) {
		map.put(AdapterImplTerms.INTEGRATION_CLIENT, new IntegratorAdapterImpl());
	}

}
