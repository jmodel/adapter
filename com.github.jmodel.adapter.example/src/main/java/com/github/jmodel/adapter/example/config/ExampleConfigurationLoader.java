package com.github.jmodel.adapter.example.config;

import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.impl.config.RootConfigurationLoader;

public class ExampleConfigurationLoader extends RootConfigurationLoader {

	private static ExampleConfigurationLoader configurationLoader;

	private ExampleConfigurationLoader() {

	}

	public static ExampleConfigurationLoader getInstance() {
		if (configurationLoader == null) {
			configurationLoader = new ExampleConfigurationLoader();
		}
		return configurationLoader;
	}

	protected void init() {

		super.init();

		cm.addConfiguration(cm.getAdapter(AdapterImplTerms.LFS_CONFIGURATOR).read("config.xml"));

	}
}
