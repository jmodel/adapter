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

	public static <T> T get(String region, String key) {

		checkAdapter();

		return cacherAdapter.get(region, key);

	}

	public static <T> void put(String region, String key, T value) {

		checkAdapter();

		cacherAdapter.put(region, key, value);

	}

	private static void checkAdapter() {
		if (cacherAdapter == null) {
			throw new RuntimeException("Cacher adapter is not found, please check service provider configuration");
		}
	}
}
