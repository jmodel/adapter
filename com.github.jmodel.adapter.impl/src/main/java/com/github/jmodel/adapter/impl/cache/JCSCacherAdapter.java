package com.github.jmodel.adapter.impl.cache;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;

import com.github.jmodel.adapter.api.cache.CacherAdapter;

/**
 * JCS cache adapter implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class JCSCacherAdapter extends CacherAdapter {

	@Override
	public <T> T get(String region, String key) {
		CacheAccess<String, T> cache = JCS.getInstance(region);
		return cache.get(key);
	}

	@Override
	public <T> void put(String region, String key, T value) {
		CacheAccess<String, T> cache = JCS.getInstance(region);
		cache.put(key, value);
	}

}
