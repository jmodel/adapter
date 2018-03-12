package com.github.jmodel.adapter.impl.log;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.log.LoggerAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.log.LoggerAdapterFactory;

/**
 * Logger adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class LoggerAdapterFactoryImpl implements LoggerAdapterFactory {

	private SortedMap<String, LoggerAdapter> map;

	public LoggerAdapterFactoryImpl() {
		map = new TreeMap<String, LoggerAdapter>();
		map.put(AdapterImplTerms.JDK_LOGGER.toString(), new JDKLoggerAdapter());
	}

	@Override
	public LoggerAdapter getAdapter(String adapterId) {
		return map.get(adapterId);
	}

}
