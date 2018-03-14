package com.github.jmodel.adapter.api.config;

import com.github.jmodel.adapter.spi.Term;

/**
 * The class impletments Configurable interface to get legal right for
 * configuration.
 * 
 * @author jianni@hotmail.com
 * @see com.github.jmodel.adapter.api.config.ConfigurationAware
 *
 */
public interface Configurable extends ConfigurationAware {

	/**
	 * Get region term of the configurable object. e.g. Adapter is a region term for
	 * adapters.
	 * 
	 * @return region term
	 */
	public Term getRegionTerm();

	/**
	 * Get item term of the configurable object. e.g. LoggerAdapter is a item term
	 * for logger adapters.
	 * 
	 * @return item term
	 */
	public Term getItemTerm();

}
