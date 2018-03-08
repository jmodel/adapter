package com.github.jmodel.adapter.impl.log;

import java.util.logging.Logger;

import com.github.jmodel.adapter.api.log.LoggerAdapter;
import com.github.jmodel.adapter.api.log.LoggerWrapper;

/**
 * Adapter to use JDK Logger.
 * 
 * @author jianni@hotmail.com
 *
 */
public class JDKLoggerAdapter extends LoggerAdapter {

	@Override
	public LoggerWrapper<Logger> getLoggerWrapper(String clzName) {
		return new JDKLoggerWrapper(Logger.getLogger(clzName));
	}

}
