package com.github.jmodel.adapter.api.config;

import com.github.jmodel.adapter.api.Initializable;

/**
 * The class extends ConfigurationLoader to construct global configuration which
 * is managed by ConfigurationManager.
 * 
 * @author jianni@hotmail.com
 * @see com.github.jmodel.adapter.api.Initializable
 *
 */
abstract class ConfigurationLoader extends Initializable {

	/**
	 * Load configurations.
	 */
	public final void load() {
		cm.addLoader(this);
		doInit();
	}

	static final String printUsage() {
		return "\t\nConfiguration must be loaded when application bootstrapping...\t\n"
				+ "For example: RootConfigurationLoader.getInstance().load()";
	}

}
