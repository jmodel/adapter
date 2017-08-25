package com.github.jmodel.adapter.persistence.exampleA;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import com.github.jmodel.adapter.persistence.exampleA.action.InsertUser;
import com.github.jmodel.adapter.spi.persistence.CrudFunctionFactory;

public class ExampleCrudFunctionFactoryImpl implements CrudFunctionFactory {

	private Map<String, BiFunction<?, ?, ?>> actionMap = new HashMap<String, BiFunction<?, ?, ?>>();

	public ExampleCrudFunctionFactoryImpl() {
		actionMap.put("xxx", new InsertUser());
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BiFunction<?, ?, ?>> T getCrudFunction(String persistenceName) {
		return (T) actionMap.get(persistenceName);
	}

}
