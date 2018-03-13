package com.github.jmodel.adapter.impl.config;

import com.github.jmodel.adapter.api.config.ConfigurationLoader;
import com.github.jmodel.adapter.impl.AdapterImplTerms;

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
		cm.addConfiguration(cm.getAdapter(AdapterImplTerms.LFS_CONFIGURATOR).read("_config.xml"));
	}
}
