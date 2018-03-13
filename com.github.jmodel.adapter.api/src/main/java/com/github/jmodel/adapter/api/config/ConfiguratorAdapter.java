package com.github.jmodel.adapter.api.config;

import com.github.jmodel.adapter.api.Adapter;
import com.github.jmodel.adapter.spi.Term;

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
	public Term getItemTerm() {
		// configurator adapter is not defined in config
		return null;
	}

	public abstract Configuration read(T t);

}
