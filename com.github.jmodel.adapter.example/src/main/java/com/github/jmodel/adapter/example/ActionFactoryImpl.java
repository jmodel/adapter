package com.github.jmodel.adapter.example;

import java.util.SortedMap;

import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.adapter.example.persistence.exampleA.dao.InsertUser;
import com.github.jmodel.japp.spi.ActionFactory;

/**
 * Action factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class ActionFactoryImpl extends ActionFactory {

	@Override
	protected void createActions(SortedMap<String, Action<?, ?, ?>> map) {
		map.put(AdapterExampleTerms.INSERT_USER, new InsertUser());
	}

}
