package com.github.jmodel.adapter.impl.log;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.log.LoggerWrapper;
import com.github.jmodel.adapter.spi.Term;

import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;

/**
 * Logger wrapper for JDK Logger.
 * 
 * @author jianni@hotmail.com
 *
 */
@SuppressWarnings("restriction")
public final class JDKLoggerWrapper implements LoggerWrapper<Logger> {

	private final static Map<String, FileHandler> fileHandlerMap = new HashMap<String, FileHandler>();

	/**
	 * JDK Logger
	 */
	private Logger logger;

	public JDKLoggerWrapper(Logger logger) {
		this.logger = logger;
	}

	//

	@Override
	public void debug(Supplier<?> msgSupplier) {
		if (logger.isLoggable(Level.ALL)) {
			LogRecord logRecord = new LogRecord(Level.ALL, (String) msgSupplier.get());
			inferCaller(logRecord);
			logger.log(logRecord);
		}
	}

	@Override
	public void trace(Supplier<?> msgSupplier) {
		if (logger.isLoggable(Level.FINE)) {
			LogRecord logRecord = new LogRecord(Level.FINE, (String) msgSupplier.get());
			inferCaller(logRecord);
			logger.log(logRecord);
		}
	}

	@Override
	public void info(Supplier<?> msgSupplier) {
		info(null, msgSupplier);
	}

	@Override
	public void info(Term category, Supplier<?> msgSupplier) {
		if (logger.isLoggable(Level.INFO)) {
			changeFileHandler(category, logger, Level.INFO);
			LogRecord logRecord = new LogRecord(Level.INFO, (String) msgSupplier.get());
			inferCaller(logRecord);
			logger.log(logRecord);
		}
	}

	@Override
	public void warn(Supplier<?> msgSupplier) {
		if (logger.isLoggable(Level.WARNING)) {
			LogRecord logRecord = new LogRecord(Level.WARNING, (String) msgSupplier.get());
			inferCaller(logRecord);
			logger.log(logRecord);
		}
	}

	@Override
	public void error(Supplier<?> msgSupplier) {
		if (logger.isLoggable(Level.SEVERE)) {
			LogRecord logRecord = new LogRecord(Level.SEVERE, (String) msgSupplier.get());
			inferCaller(logRecord);
			logger.log(logRecord);
		}
	}

	//

	private void inferCaller(LogRecord logRecord) {
		JavaLangAccess access = SharedSecrets.getJavaLangAccess();
		Throwable throwable = new Throwable();
		int depth = access.getStackTraceDepth(throwable);
		boolean lookingForLogger = true;
		for (int ix = 0; ix < depth; ix++) {
			StackTraceElement frame = access.getStackTraceElement(throwable, ix);
			String cname = frame.getClassName();
			boolean isLoggerImpl = isLoggerImplFrame(cname);
			if (lookingForLogger) {
				if (isLoggerImpl) {
					lookingForLogger = false;
				}
			} else {
				if (!isLoggerImpl) {
					if (!cname.startsWith("java.lang.reflect.") && !cname.startsWith("sun.reflect.")) {
						logRecord.setSourceClassName(cname);
						logRecord.setSourceMethodName(frame.getMethodName());
						return;
					}
				}
			}
		}

	}

	private boolean isLoggerImplFrame(String cname) {
		return cname.equals("com.github.jmodel.adapter.Logger");
	}

	private void changeFileHandler(Term category, Logger logger, Level level) {

		String fileName = "d:\\my.log";
		if (category != null && category.getText().equals(AdapterTerms.LOGGER_PFM)) {
			fileName = "d:\\pfm.log";
		}

		try {
			FileHandler fileHandler = fileHandlerMap.get(fileName);
			if (fileHandler != null) {

				for (Handler handler : logger.getHandlers()) {
					if (handler instanceof FileHandler) {
						if (handler == fileHandler) {
							handler.setLevel(level);
						} else {
							handler.setLevel(Level.OFF);
						}
					}
				}

			} else {
				synchronized (fileName) {
					fileHandler = new FileHandler(fileName);
					fileHandlerMap.put(fileName, fileHandler);
					logger.addHandler(fileHandler);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
