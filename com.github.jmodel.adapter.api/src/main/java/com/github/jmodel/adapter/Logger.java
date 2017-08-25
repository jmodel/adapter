package com.github.jmodel.adapter;

import com.github.jmodel.adapter.api.AdapterFactoryService;
import com.github.jmodel.adapter.api.log.LoggerAdapter;
import com.github.jmodel.adapter.api.log.LoggerWrapper;

/**
 * Public API for Log.
 * 
 * @author jianni@hotmail.com
 *
 */
public class Logger {

	private final static LoggerAdapter loggerAdapter = AdapterFactoryService.getInstance()
			.getAdapter(LoggerAdapter.class);

	private LoggerWrapper<?> loggerWrapper;

	private Logger(LoggerWrapper<?> loggerAdapter) {
		this.loggerWrapper = loggerAdapter;
	}

	public static Logger getLogger(String clzName) {
		if (loggerAdapter == null) {
			throw new RuntimeException("Logger adapter is not found, please check service provider configuration");
		}
		return new Logger(loggerAdapter.getLoggerWrapper(clzName));
	}

	/**
	 * Log a message at the DEBUG level.
	 *
	 * @param msg
	 *            the message string to be logged
	 */
	public void debug(String msg) {

	}

	/**
	 * Log a message at the TRACE level.
	 *
	 * @param msg
	 *            the message string to be logged
	 */
	public void trace(String msg) {

	}

	/**
	 * Log a message at the INFO level.
	 *
	 * @param msg
	 *            the message string to be logged
	 */
	public void info(String msg) {
		loggerWrapper.info(msg);
	}

	/**
	 * Log a message at the WARN level.
	 *
	 * @param msg
	 *            the message string to be logged
	 */
	public void warn(String msg) {

	}

	/**
	 * Log a message at the ERROR level.
	 *
	 * @param msg
	 *            the message string to be logged
	 */
	public void error(String msg) {

	}

}
