package com.github.jmodel.adapter.example;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.adapter.example.persistence.exampleA.dao.InsertUser;
import com.github.jmodel.japp.spi.ActionFactory;

/**
 * Action factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class ActionFactoryImpl implements ActionFactory {

	private SortedMap<String, Action<?, ?, ?>> map;

	public ActionFactoryImpl() {
		map = new TreeMap<String, Action<?, ?, ?>>();
		map.put(AdapterExampleTerms.INSERT_USER, new InsertUser());
	}

	@Override
	public Action<?, ?, ?> getAction(String actionId) {
		if (actionId == null) {
			return null;
		}
		return map.get(actionId);
	}

}
