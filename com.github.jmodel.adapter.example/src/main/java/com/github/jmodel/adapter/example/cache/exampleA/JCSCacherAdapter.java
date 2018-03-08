package com.github.jmodel.adapter.example.cache.exampleA;

import com.github.jmodel.adapter.Cacher;
import com.github.jmodel.adapter.Logger;
import com.github.jmodel.adapter.example.config.ExampleConfigurationLoader;

public class JCSCacherAdapter {

	static {
		ExampleConfigurationLoader.getInstance().load();
	}

	private final static Logger logger = Logger.getLogger(JCSCacherAdapter.class.getName());

	public static void main(String[] args) {

		Cacher cacher = Cacher.getCacher();

		cacher.put("objectCache", "1", new String("22"));

		logger.info(() -> cacher.get("objectCache", "1"));
		logger.info(() -> cacher.get("objectCache", "1"));
	}
}
