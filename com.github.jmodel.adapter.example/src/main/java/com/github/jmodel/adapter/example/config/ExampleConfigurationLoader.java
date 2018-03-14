package com.github.jmodel.adapter.example.config;

import com.github.jmodel.adapter.api.config.RootConfigurationLoader;

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

	@Override
	protected void init() {

		super.init();

		addConfiguration(cm.getAdapter().read("config.xml"));

	}
}
