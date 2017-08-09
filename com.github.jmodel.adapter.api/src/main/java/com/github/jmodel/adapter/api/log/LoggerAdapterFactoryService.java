package com.github.jmodel.adapter.api.log;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import com.github.jmodel.adapter.spi.log.LoggerAdapterFactory;

/**
 * Logger adapter factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
public class LoggerAdapterFactoryService {

	private static LoggerAdapterFactoryService service;
	private ServiceLoader<LoggerAdapterFactory> loader;

	private LoggerAdapterFactoryService() {
		loader = ServiceLoader.load(LoggerAdapterFactory.class);
	}

	public static synchronized LoggerAdapterFactoryService getInstance() {
		if (service == null) {
			service = new LoggerAdapterFactoryService();
		}
		return service;
	}

	public LoggerAdapter getLoggerAdapter() {

		LoggerAdapter adapter = null;

		try {
			Iterator<LoggerAdapterFactory> loggerAdapterFactorys = loader.iterator();
			while (adapter == null && loggerAdapterFactorys.hasNext()) {
				LoggerAdapterFactory loggerAdapterFactory = loggerAdapterFactorys.next();
				adapter = loggerAdapterFactory.getLoggerAdapter();
			}
		} catch (ServiceConfigurationError serviceError) {
			adapter = null;
			serviceError.printStackTrace();

		}
		return adapter;
	}
}
