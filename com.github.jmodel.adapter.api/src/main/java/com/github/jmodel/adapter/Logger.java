package com.github.jmodel.adapter;

import java.util.function.Supplier;

import com.github.jmodel.adapter.api.Facade;
import com.github.jmodel.adapter.api.Term;
import com.github.jmodel.adapter.api.log.LoggerAdapter;
import com.github.jmodel.adapter.api.log.LoggerAdapterFactoryService;
import com.github.jmodel.adapter.api.log.LoggerWrapper;

/**
 * Simple log facade.
 * <p>
 * In enterprise environment, log feature required could be very flexible and
 * complicated. For example, the message needs to be writen to local disk,
 * remote database, remote log service, or sent to someone via email at the same
 * time. Embedding the above (even more complex) in business logic code is not a
 * good idea. Actually, when writing business logic code, the only thing we
 * should care is logging something, why need to consider 'how-detail' at that
 * time.
 * <p>
 * Logger can shield the complexity. The business logic coder just need to know
 * 'log' concept and 'how' term.
 * <p>
 * The matter of log is handed over to log expert who is able to write a
 * specific log adapter. Term is common language between log expert and business
 * logic coder.
 * <p>
 * For performance reason, the log methods enforce to use funtional interface
 * (delayed execution) to get message.
 * 
 * @author jianni@hotmail.com
 * @see com.github.jmodel.adapter.api.Facade
 *
 */
public final class Logger extends Facade {

	/**
	 * Logger adapter factory service
	 */
	private final static LoggerAdapterFactoryService _logger_sp = LoggerAdapterFactoryService.getInstance();

	private LoggerWrapper<?> loggerWrapper;

	private LoggerAdapter loggerAdapter;

	/**
	 * internal use
	 * 
	 * @param id
	 *            id of logger adapter
	 * @param loggerAdapter
	 *            logger adapter instance
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
	 *            logger wrapper
	 */
	private Logger(LoggerWrapper<?> loggerWrapper) {
		this.loggerWrapper = loggerWrapper;

	}

	//

	/**
	 * Create a Logger object which uses default logger adapter to write message.
	 * 
	 * @param name
	 *            A name for the logger
	 * @return a suitable Logger
	 */
	public static Logger getLogger(String name) {
		return getLogger(null, name);
	}

	/**
	 * Create a Logger object which uses the logger adapter specified by term to
	 * write message.
	 * 
	 * @param term
	 *            A term for the logger adapter
	 * @param name
	 *            A name for the logger
	 * @return a suitable Logger
	 */
	public static Logger getLogger(Term t, String name) {
		String loggerAdapterId = getAdapterId(AdapterTerms.LOGGER, t);
		Logger logger = fm.getFacade(loggerAdapterId);
		if (logger != null) {
			return new Logger(logger.getLoggerAdapter().getLoggerWrapper(name));
		}

		synchronized (fm) {
			if (logger == null) {
				logger = new Logger(loggerAdapterId, _logger_sp.getAdapter(loggerAdapterId));
				fm.addFacade(logger);
			}
			return new Logger(logger.getLoggerAdapter().getLoggerWrapper(name));
		}
	}

	//

	/**
	 * Log a message at the DEBUG level.
	 *
	 * @param msgSupplier
	 *            the message supplier to be logged
	 */
	public void debug(Supplier<String> msgSupplier) {

	}

	/**
	 * Log a message at the TRACE level.
	 *
	 * @param msgSupplier
	 *            the message supplier to be logged
	 */
	public void trace(Supplier<String> msgSupplier) {

	}

	/**
	 * Log a message at the INFO level.
	 *
	 * @param msgSupplier
	 *            the message supplier to be logged
	 */
	public void info(Supplier<String> msgSupplier) {
		loggerWrapper.info(msgSupplier);
	}

	/**
	 * Log a message at the WARN level.
	 *
	 * @param msgSupplier
	 *            the message supplier to be logged
	 */
	public void warn(Supplier<String> msgSupplier) {
		loggerWrapper.warn(msgSupplier);
	}

	/**
	 * Log a message at the ERROR level.
	 *
	 * @param msgSupplier
	 *            the message supplier to be logged
	 */
	public void error(Supplier<String> msgSupplier) {
		loggerWrapper.error(msgSupplier);
	}

	//

	private LoggerAdapter getLoggerAdapter() {
		return loggerAdapter;
	}

}
