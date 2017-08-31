package com.github.jmodel.adapter.api.cache;

import com.github.jmodel.adapter.api.Adapter;

/**
 * Cacher adapter
 * 
 * @author jianni@hotmail.com
 *
 */
public interface CacherAdapter extends Adapter {

	public <T> T get(String region, String key);
	
	public <T> void put(String region, String key, T value);
}
