package com.github.jmodel.adapter.impl.log;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.github.jmodel.adapter.api.log.LoggerWrapper;

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
		if (logger.isLoggable(Level.INFO)) {
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

}
