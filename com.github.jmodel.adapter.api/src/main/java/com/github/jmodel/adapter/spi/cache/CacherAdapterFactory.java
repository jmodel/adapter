package com.github.jmodel.adapter.spi.cache;

import com.github.jmodel.adapter.api.cache.CacherAdapter;

/**
 * Cacher adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface CacherAdapterFactory {

	public CacherAdapter getAdapter(String cacherAdapterId);

}
