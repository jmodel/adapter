package com.github.jmodel.adapter.spi.persistence;

import java.util.function.BiFunction;

/**
 * The factory is used to create function for database operation like create,
 * read, update and delete.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface CrudFunctionFactory {

	public <T extends BiFunction<?, ?, ?>> T getCrudFunction(String persistenceName);
}
