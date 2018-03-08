package com.github.jmodel.adapter.api.cache;

import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.Adapter;

/**
 * Cacher adapter
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class CacherAdapter extends Adapter {

	@Override
	public String getItemId() {
		return AdapterTerms.CACHER;
	}

	//

	public abstract <T> T get(String region, String key);

	public abstract <T> void put(String region, String key, T value);
}
