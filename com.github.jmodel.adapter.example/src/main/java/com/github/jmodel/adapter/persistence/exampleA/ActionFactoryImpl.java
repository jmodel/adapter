package com.github.jmodel.adapter.persistence.exampleA;

import java.util.HashMap;
import java.util.Map;

import com.github.jmodel.adapter.persistence.exampleA.dao.InsertUser;
import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.adapter.spi.persistence.CrudFunctionFactory;

public class ActionFactoryImpl implements CrudFunctionFactory {

	private Map<String, Action<?, ?, ?>> actionMap = new HashMap<String, Action<?, ?, ?>>();

	public ActionFactoryImpl() {
		actionMap.put("insertUser", new InsertUser());
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Action<?, ?, ?>> T getCrudFunction(String persistenceName) {
		return (T) actionMap.get(persistenceName);
	}

}
