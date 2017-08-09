package com.github.jmodel.adapter;

import com.github.jmodel.adapter.api.log.LoggerAdapter;
import com.github.jmodel.adapter.api.log.LoggerAdapterFactoryService;

public class Logger {

	/**
	 * Log a message at the DEBUG level.
	 *
	 * @param msg
	 *            the message string to be logged
	 */
	public void debug(String clzName, String msg) {

	}

	/**
	 * Log a message at the TRACE level.
	 *
	 * @param msg
	 *            the message string to be logged
	 */
	public void trace(String clzName, String msg) {

	}

	/**
	 * Log a message at the INFO level.
	 *
	 * @param msg
	 *            the message string to be logged
	 */
	public void info(String clzName, String msg) {
		LoggerAdapter loggerAdapter = LoggerAdapterFactoryService.getInstance().getLoggerAdapter();
		loggerAdapter.info(clzName, msg);
	}

	/**
	 * Log a message at the WARN level.
	 *
	 * @param msg
	 *            the message string to be logged
	 */
	public void warn(String clzName, String msg) {

	}

	/**
	 * Log a message at the ERROR level.
	 *
	 * @param msg
	 *            the message string to be logged
	 */
	public void error(String clzName, String msg) {

	}
}
