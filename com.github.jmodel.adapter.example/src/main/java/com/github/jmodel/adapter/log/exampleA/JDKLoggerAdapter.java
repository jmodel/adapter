package com.github.jmodel.adapter.log.exampleA;

import com.github.jmodel.adapter.Logger;

public class JDKLoggerAdapter {

	private final static Logger logger = Logger.getLogger(JDKLoggerAdapter.class.getName());

	public static void main(String[] args) {
		logger.info("This log is printed out by JDK Logger");
	}

}
