package com.github.jmodel.adapter.cache.exampleA;

import com.github.jmodel.adapter.Cacher;
import com.github.jmodel.adapter.Logger;

public class JCSCacherAdapter {

	private final static Logger logger = Logger.getLogger(JCSCacherAdapter.class.getName());

	public static void main(String[] args) {

		Cacher.put("objectCache", "1", new String("22"));

		logger.info(Cacher.get("objectCache", "1"));
		logger.info(Cacher.get("objectCache", "1"));
	}
}
