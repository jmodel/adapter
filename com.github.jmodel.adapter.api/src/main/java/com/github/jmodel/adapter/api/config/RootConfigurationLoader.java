package com.github.jmodel.adapter.api.config;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public class RootConfigurationLoader extends ConfigurationLoader {

	private static RootConfigurationLoader configurationLoader;

	public static RootConfigurationLoader getInstance() {

		if (configurationLoader == null) {
			configurationLoader = new RootConfigurationLoader();
		}
		return configurationLoader;
	}

	protected void init() {
		addConfiguration(cm.getAdapter().read("_config.xml"));
	}

}
