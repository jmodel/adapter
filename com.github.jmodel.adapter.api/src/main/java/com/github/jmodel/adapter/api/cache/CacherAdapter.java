package com.github.jmodel.adapter.api.cache;

import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.Adapter;
import com.github.jmodel.adapter.spi.Term;

/**
 * Cacher adapter
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class CacherAdapter extends Adapter {

	@Override
	public Term getItemTerm() {
		return tfs.getTerm(AdapterTerms.CACHER_ADAPTER);
	}

	//

	public abstract <T> T get(String region, String key);

	public abstract <T> void put(String region, String key, T value);
}
