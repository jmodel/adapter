package com.github.jmodel.adapter.api.log;

import com.github.jmodel.adapter.api.Adapter;

/**
 * Logger adapter is usually used in enterprise application. It aims at complex
 * log requirement. 
 * 
 * @author jianni@hotmail.com
 *
 */
public interface LoggerAdapter extends Adapter {

	public LoggerWrapper<?> getLoggerWrapper(String clzName);

}
