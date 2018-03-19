package com.github.jmodel.adapter.spi.integration;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.integration.IntegratorAdapter;
import com.github.jmodel.adapter.spi.Factory;

/**
 * Integrator adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class IntegratorAdapterFactory extends Factory<IntegratorAdapter> {

	protected final void init() {
		map = new TreeMap<String, IntegratorAdapter>();
		createIntegratorAdapters(map);
	}

	protected abstract void createIntegratorAdapters(SortedMap<String, IntegratorAdapter> map);
}
