package com.github.jmodel.adapter;

import com.github.jmodel.adapter.config.Configuration;
import com.github.jmodel.adapter.config.ConfigurationLoader;

public class ConfigurationExample {

	private final static Logger logger = Logger.getLogger(ConfigurationExample.class.getName());

	public final static void main(String[] args) {

		try {
			Configuration configuration = ConfigurationLoader.getInstance().getConfiguration();
			logger.info("hello");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
