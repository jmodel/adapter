package com.github.jmodel.adapter.example.search.exampleA;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.Logger;
import com.github.jmodel.adapter.Searcher;
import com.github.jmodel.adapter.example.config.ExampleConfigurationLoader;

public class ES5SearcherAdapter {

	static {
		ExampleConfigurationLoader.getInstance().load();
	}

	private final static Logger logger = Logger.getLogger(ES5SearcherAdapter.class.getName());

	public static void main(String[] args) {

		Searcher searcher = Searcher.getSearcher();

		try {

			searcher.index("/myindex/mytype", "{\"A\" : 22}");

			/*
			 * waiting for response of async request
			 */
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			logger.info(searcher.search("/myindex/mytype", "{\"query\" : {\"match_all\" : {}}}"));

		} catch (AdapterException e) {
			e.printStackTrace();
		}
	}

}
