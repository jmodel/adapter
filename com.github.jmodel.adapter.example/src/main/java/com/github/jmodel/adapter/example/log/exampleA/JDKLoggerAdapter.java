package com.github.jmodel.adapter.example.log.exampleA;

import com.github.jmodel.adapter.Logger;
import com.github.jmodel.adapter.example.config.ExampleConfigurationLoader;
import com.github.jmodel.adapter.impl.AdapterImplTerms;

public class JDKLoggerAdapter {

	static {
		ExampleConfigurationLoader.getInstance().load();
	}

	private final static Logger logger = Logger.getLogger(AdapterImplTerms.JDK_LOGGER,
			JDKLoggerAdapter.class.getName());

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().hashCode());
		logger.info(() -> getMsg() + "This info log is printed out by JDK Logger");

		logger.warn("This warning log is printed out by JDK Logger");

		logger.error("This error log is printed out by JDK Logger");
	}

	private static String getMsg() {
		System.out.println("======");
		return "xxx";
	}

}
