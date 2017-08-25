package com.github.jmodel.adapter.spi.persistence;

import com.github.jmodel.adapter.api.persistence.Action;

/**
 * The factory is used to create function for database operation like create,
 * read, update and delete.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface CrudFunctionFactory {

	public <T extends Action<?, ?, ?>> T getCrudFunction(String persistenceName);
}
