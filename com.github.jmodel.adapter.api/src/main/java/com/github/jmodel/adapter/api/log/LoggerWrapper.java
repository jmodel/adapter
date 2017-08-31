package com.github.jmodel.adapter.api.log;

/**
 * Logger wrapper
 * 
 * @author jianni@hotmail.com
 *
 * @param <T>
 *            logger impl class
 */
public interface LoggerWrapper<T> {

	public void info(String msg);

	public void warn(String msg);

	public void error(String msg);
}
