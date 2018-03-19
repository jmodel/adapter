package com.github.jmodel.adapter.spi.persistence;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.persistence.PersisterAdapter;
import com.github.jmodel.adapter.spi.Factory;

/**
 * Persister adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class PersisterAdapterFactory extends Factory<PersisterAdapter> {

	protected final void init() {
		map = new TreeMap<String, PersisterAdapter>();
		createPersisterAdapters(map);
	}

	protected abstract void createPersisterAdapters(SortedMap<String, PersisterAdapter> map);
}
