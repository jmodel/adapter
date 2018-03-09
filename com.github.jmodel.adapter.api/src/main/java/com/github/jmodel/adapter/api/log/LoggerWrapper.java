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

	public void debug(Supplier<String> msgSupplier);

	public void trace(Supplier<String> msgSupplier);

	public void info(Supplier<String> msgSupplier);

	public void warn(Supplier<String> msgSupplier);

	public void error(Supplier<String> msgSupplier);
}
