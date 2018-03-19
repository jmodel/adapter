package com.github.jmodel.adapter.impl.log;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.github.jmodel.adapter.api.log.LoggerAdapter;
import com.github.jmodel.adapter.api.log.LoggerWrapper;

/**
 * Adapter to use JDK Logger.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class JDKLoggerAdapter extends LoggerAdapter<String> {

	private Map<Logger, JDKLoggerWrapper> map = new HashMap<Logger, JDKLoggerWrapper>();

	@Override
	public LoggerWrapper<Logger> getLoggerWrapper(String clzName) {
		Logger logger = Logger.getLogger(clzName);
		JDKLoggerWrapper wrapper = map.get(logger);
		if (wrapper != null) {
			return wrapper;
		}

		synchronized (logger) {
			if (wrapper == null) {
				wrapper = new JDKLoggerWrapper(logger);
				map.put(logger, wrapper);
			}
			return wrapper;
		}

	}

}
