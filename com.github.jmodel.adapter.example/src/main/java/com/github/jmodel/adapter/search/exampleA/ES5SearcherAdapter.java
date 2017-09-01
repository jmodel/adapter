package com.github.jmodel.adapter.search.exampleA;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.Logger;
import com.github.jmodel.adapter.impl.search.ES5RestSearchAdapter;

public class ES5SearcherAdapter {

	private final static Logger logger = Logger.getLogger(ES5SearcherAdapter.class.getName());

	public static void main(String[] args) {

		try {
			ES5RestSearchAdapter adatper = new ES5RestSearchAdapter();
			adatper.index("/myindex/mytype", "{\"A\" : 22}");

			/*
			 * waiting for response of async request
			 */
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			ES5RestSearchAdapter adatper = new ES5RestSearchAdapter();
			logger.info(adatper.search("/myindex/mytype", "{\"query\" : {\"match_all\" : {}}}"));

		} catch (AdapterException e) {
			e.printStackTrace();
		}
	}

}
