package com.github.jmodel.adapter.api.log;

import java.util.function.Supplier;

import com.github.jmodel.adapter.spi.Term;

/**
 * Logger wrapper
 * 
 * @author jianni@hotmail.com
 *
 * @param <T>
 *            logger impl class
 */
public interface LoggerWrapper<T> {

	public void debug(Supplier<?> msgSupplier);

	public void trace(Supplier<?> msgSupplier);

	public void info(Supplier<?> msgSupplier);

	public void info(Term category, Supplier<?> msgSupplier);

	public void warn(Supplier<?> msgSupplier);

	public void error(Supplier<?> msgSupplier);
}
