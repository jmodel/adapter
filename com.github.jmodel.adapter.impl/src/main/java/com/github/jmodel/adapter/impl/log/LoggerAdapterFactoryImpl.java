package com.github.jmodel.adapter.impl.log;

import java.util.SortedMap;

import com.github.jmodel.adapter.api.log.LoggerAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.log.LoggerAdapterFactory;

/**
 * Logger adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class LoggerAdapterFactoryImpl extends LoggerAdapterFactory {

	@Override
	protected void createLoggerAdapters(SortedMap<String, LoggerAdapter> map) {
		map.put(AdapterImplTerms.JDK_LOGGER, new JDKLoggerAdapter());

	}

}
