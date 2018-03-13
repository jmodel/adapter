package com.github.jmodel.adapter.api.config;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.github.jmodel.adapter.spi.config.ConfiguratorAdapterFactory;

/**
 * Configurator adapter factory service. In some complex scenarios,
 * configuration might be from multiple locations, e.g. local file system,
 * remote database, remote configuration service. Delegating the control to
 * client is a good approach.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class ConfiguratorAdapterFactoryService {

	private static ConfiguratorAdapterFactoryService service;

	private ServiceLoader<ConfiguratorAdapterFactory> loader;

	private ConfiguratorAdapterFactoryService() {
		loader = ServiceLoader.load(ConfiguratorAdapterFactory.class);
	}

	public static synchronized ConfiguratorAdapterFactoryService getInstance() {
		if (service == null) {
			service = new ConfiguratorAdapterFactoryService();
		}
		return service;
	}

	/**
	 * Adatper implementation should provide a default ConfiguratorAdapter. The
	 * configuratorAdapterId of the default implementation is null.
	 * 
	 * @return ConfiguratorAdapter
	 */
	public ConfiguratorAdapter<?> getAdapter() {
		return getAdapter(null);
	}

	public ConfiguratorAdapter<?> getAdapter(String configuratorAdapterId) {

		ConfiguratorAdapter<?> configuratorAdapter = null;

		Iterator<ConfiguratorAdapterFactory> configuratorAdapterFactorys = loader.iterator();
		while (configuratorAdapter == null && configuratorAdapterFactorys.hasNext()) {
			ConfiguratorAdapterFactory configuratorAdapterFactory = configuratorAdapterFactorys.next();
			configuratorAdapter = configuratorAdapterFactory.getAdapter(configuratorAdapterId);
		}

		return configuratorAdapter;
	}

}
