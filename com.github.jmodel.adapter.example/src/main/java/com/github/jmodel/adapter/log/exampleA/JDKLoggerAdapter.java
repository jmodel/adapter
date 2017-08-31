package com.github.jmodel.adapter.log.exampleA;

import com.github.jmodel.adapter.Logger;

public class JDKLoggerAdapter {

	private final static Logger logger = Logger.getLogger(JDKLoggerAdapter.class.getName());

	public static void main(String[] args) {
		
		logger.info("This info log is printed out by JDK Logger");

		logger.warn("This warning log is printed out by JDK Logger");

		logger.error("This error log is printed out by JDK Logger");
	}

}
