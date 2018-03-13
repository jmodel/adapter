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
public class MapperAdapterFactoryService {

	private static MapperAdapterFactoryService service;

	private ServiceLoader<MapperAdapterFactory> loader;

	private MapperAdapterFactoryService() {
		loader = ServiceLoader.load(MapperAdapterFactory.class);
	}

	public static synchronized MapperAdapterFactoryService getInstance() {
		if (service == null) {
			service = new MapperAdapterFactoryService();
		}
		return service;
	}

	public MapperAdapter getAdapter(String text) {

		MapperAdapter mapperAdapter = null;

		Iterator<MapperAdapterFactory> mapperAdapterFactorys = loader.iterator();
		while (mapperAdapter == null && mapperAdapterFactorys.hasNext()) {
			MapperAdapterFactory mapperAdapterFactory = mapperAdapterFactorys.next();
			mapperAdapter = mapperAdapterFactory.getAdapter(text);
		}
		return mapperAdapter;
	}

}
