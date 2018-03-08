package com.github.jmodel.adapter.api.config;

import com.github.jmodel.adapter.api.Adapter;

/**
 * Configurator adapter
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class ConfiguratorAdapter<T> extends Adapter {

	/**
	 * 
	 */
	@Override
	public String getItemId() {
		// configurator adapter is not defined in config
		return null;
	}

	public abstract Configuration read(T t);

}
