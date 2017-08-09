package com.github.jmodel.adapter.spi.log;

import com.github.jmodel.adapter.api.log.LoggerAdapter;

/**
 * Logger adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface LoggerAdapterFactory {

	public LoggerAdapter getLoggerAdapter();
}
