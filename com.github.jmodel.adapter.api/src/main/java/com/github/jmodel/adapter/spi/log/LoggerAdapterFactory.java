package com.github.jmodel.adapter.spi.log;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.log.LoggerAdapter;
import com.github.jmodel.adapter.spi.Factory;

/**
 * Logger adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class LoggerAdapterFactory extends Factory<LoggerAdapter<?>> {

	protected final void init() {
		map = new TreeMap<String, LoggerAdapter<?>>();
		createLoggerAdapters(map);
	}

	protected abstract void createLoggerAdapters(SortedMap<String, LoggerAdapter<?>> map);
}
