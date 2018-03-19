package com.github.jmodel.adapter.api.config;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.spi.config.ConfiguratorAdapterFactory;

/**
 * Configurator adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class ConfiguratorAdapterFactoryImpl implements ConfiguratorAdapterFactory {

	private SortedMap<String, ConfiguratorAdapter<?>> map;

	public ConfiguratorAdapterFactoryImpl() {
		map = new TreeMap<String, ConfiguratorAdapter<?>>();
		map.put(AdapterTerms.CONFIGURATOR_LFS, new LocalFSConfiguratorAdapter());
	}

	@Override
	public ConfiguratorAdapter<?> getAdapter(String adapterId) {

		if (adapterId == null) {
			return new LocalFSConfiguratorAdapter();
		}
		return map.get(adapterId);
	}

}
