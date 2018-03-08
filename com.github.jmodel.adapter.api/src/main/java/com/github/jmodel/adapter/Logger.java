package com.github.jmodel.adapter;

import com.github.jmodel.adapter.api.log.LoggerAdapter;
import com.github.jmodel.adapter.api.log.LoggerAdapterFactoryService;
import com.github.jmodel.adapter.api.log.LoggerWrapper;

/**
 * Public API for Log.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class Logger extends Facade {

	private final static LoggerAdapterFactoryService _logger_sp = LoggerAdapterFactoryService.getInstance();

	private LoggerWrapper<?> loggerWrapper;

	private LoggerAdapter loggerAdapter;

	/**
	 * internal use
	 * 
	 * @param id
	 * @param loggerAdapter
	 */
	private Logger(String id, LoggerAdapter loggerAdapter) {
		if (loggerAdapter == null) {
			throw new RuntimeException("Logger adapter is not found.");
		}
		this.id = id;
		this.loggerAdapter = loggerAdapter;
	}

	/**
	 * external use
	 * 
	 * @param loggerWrapper
	 */
	private Logger(LoggerWrapper<?> loggerWrapper) {
		this.loggerWrapper = loggerWrapper;

	}

	//

	public static Logger getLogger(String clzName) {
		return getLogger(null, clzName);
	}

	public static Logger getLogger(String name, String clzName) {
		String loggerAdapterId = getAdapterId(AdapterTerms.LOGGER, name);
		Logger logger = facadeManager.getFacade(loggerAdapterId);
		if (logger != null) {
			return new Logger(logger.getLoggerAdapter().getLoggerWrapper(clzName));
		}

		synchronized (facadeManager) {
			if (logger == null) {
				logger = new Logger(loggerAdapterId, _logger_sp.getAdapter(loggerAdapterId));
				facadeManager.addFacade(logger);
			}
			return new Logger(logger.getLoggerAdapter().getLoggerWrapper(clzName));
		}
	}

	public LoggerAdapter getLoggerAdapter() {
		return loggerAdapter;
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
		loggerWrapper.warn(msg);
	}

	/**
	 * Log a message at the ERROR level.
	 *
	 * @param msg
	 *            the message string to be logged
	 */
	public void error(String msg) {
		loggerWrapper.error(msg);
	}

}
