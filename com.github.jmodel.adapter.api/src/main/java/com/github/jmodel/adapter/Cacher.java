package com.github.jmodel.adapter;

import com.github.jmodel.adapter.api.AdapterFactoryService;
import com.github.jmodel.adapter.api.cache.CacherAdapter;

/**
 * Public API for cache.
 * 
 * @author jianni@hotmail.com
 *
 */
public class Cacher {

	private final static CacherAdapter cacherAdapter = AdapterFactoryService.getInstance()
			.getAdapter(CacherAdapter.class);

	public static void put(String namespace, String key, Object value) {

		checkAdapter();

	}

	private static void checkAdapter() {
		if (cacherAdapter == null) {
			throw new RuntimeException("Cacher adapter is not found, please check service provider configuration");
		}
	}
}
