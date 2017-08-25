package com.github.jmodel.adapter.impl.persistence;

import java.util.function.BiFunction;

import com.github.jmodel.adapter.spi.persistence.CrudFunctionFactory;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public class CrudFunctionFactoryImpl implements CrudFunctionFactory {

	public <T extends BiFunction<?, ?, ?>> T getCrudFunction(String persistenceName) {
		return null;
	}
}
