package com.github.jmodel.adapter.api.config;

import com.github.jmodel.adapter.api.Adapter;
import com.github.jmodel.adapter.spi.Term;

/**
 * The class extends ConfiguratorAdapter to construct a Configuration instance
 * which will be added to ConfigurationManager.
 * 
 * @author jianni@hotmail.com
 * @see com.github.jmodel.adapter.api.Adapter
 *
 */
public abstract class ConfiguratorAdapter<T> extends Adapter {

	@Override
	public Term getItemTerm() {
		// ignore, the item term is not in configuration
		return null;
	}

	/**
	 * Construct configuration object.
	 * 
	 * @param t
	 *            configuration data source
	 * @return Configuration
	 */
	public abstract Configuration read(T t);

}
