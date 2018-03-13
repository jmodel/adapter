package com.github.jmodel.adapter.api.log;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.github.jmodel.adapter.spi.log.LoggerAdapterFactory;

/**
 * Logger adapter factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class LoggerAdapterFactoryService {

	private static LoggerAdapterFactoryService service;

	private ServiceLoader<LoggerAdapterFactory> loader;

	private LoggerAdapterFactoryService() {
		loader = ServiceLoader.load(LoggerAdapterFactory.class);
	}

	public static LoggerAdapterFactoryService getInstance() {
		if (service != null) {
			return service;
		}

		synchronized (LoggerAdapterFactoryService.class) {
			if (service == null) {
				service = new LoggerAdapterFactoryService();
			}
			return service;
		}
	}

	public LoggerAdapter getAdapter(String text) {

		LoggerAdapter loggerAdapter = null;

		Iterator<LoggerAdapterFactory> loggerAdapterFactorys = loader.iterator();
		while (loggerAdapter == null && loggerAdapterFactorys.hasNext()) {
			LoggerAdapterFactory loggerAdapterFactory = loggerAdapterFactorys.next();
			loggerAdapter = loggerAdapterFactory.getAdapter(text);
		}
		return loggerAdapter;
	}

}
