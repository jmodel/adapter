package com.github.jmodel.adapter.api.log;

import java.util.function.Supplier;

/**
 * Logger wrapper
 * 
 * @author jianni@hotmail.com
 *
 * @param <T>
 *            logger impl class
 */
public interface LoggerWrapper<T> {

	public void info(Supplier<String> msgSupplier);

	public void warn(String msg);

	public void error(String msg);
}
