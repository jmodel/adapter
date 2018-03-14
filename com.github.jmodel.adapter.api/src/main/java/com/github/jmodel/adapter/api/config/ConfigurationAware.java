package com.github.jmodel.adapter.api.config;

import com.github.jmodel.adapter.api.config.ConfigurationManager;

/**
 * The class implements this interface can use configuration manager.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface ConfigurationAware {

	/**
	 * Configuration manager is a single instance, used to manage configuration.
	 */
	public final static ConfigurationManager cm = ConfigurationManager.getInstance();

}
