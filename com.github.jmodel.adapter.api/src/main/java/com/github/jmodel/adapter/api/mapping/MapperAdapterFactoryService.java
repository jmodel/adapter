package com.github.jmodel.adapter.api.mapping;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.github.jmodel.adapter.spi.mapping.MapperAdapterFactory;

/**
 * Mapper adapter factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class MapperAdapterFactoryService {

	private static MapperAdapterFactoryService service;

	private ServiceLoader<MapperAdapterFactory> loader;

	private MapperAdapterFactoryService() {
		loader = ServiceLoader.load(MapperAdapterFactory.class);
	}

	public static MapperAdapterFactoryService getInstance() {

		if (service != null) {
			return service;
		}

		synchronized (MapperAdapterFactoryService.class) {
			if (service == null) {
				service = new MapperAdapterFactoryService();
			}
			return service;
		}
	}

	public MapperAdapter getAdapter(String text) {

		MapperAdapter mapperAdapter = null;

		Iterator<MapperAdapterFactory> mapperAdapterFactorys = loader.iterator();
		while (mapperAdapter == null && mapperAdapterFactorys.hasNext()) {
			MapperAdapterFactory mapperAdapterFactory = mapperAdapterFactorys.next();
			mapperAdapter = mapperAdapterFactory.create(text);
		}
		return mapperAdapter;
	}

}
