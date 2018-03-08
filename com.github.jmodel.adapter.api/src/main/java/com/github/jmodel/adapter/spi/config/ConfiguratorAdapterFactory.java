package com.github.jmodel.adapter.spi.config;

import com.github.jmodel.adapter.api.config.ConfiguratorAdapter;

/**
 * Configurator adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface ConfiguratorAdapterFactory {

	public ConfiguratorAdapter<?> getAdapter(String configuratorAdapterId);

}
