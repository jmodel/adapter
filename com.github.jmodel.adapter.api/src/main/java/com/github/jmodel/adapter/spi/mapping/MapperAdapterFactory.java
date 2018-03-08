package com.github.jmodel.adapter.spi.mapping;

import com.github.jmodel.adapter.api.mapping.MapperAdapter;

/**
 * Mapper adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface MapperAdapterFactory {

	public MapperAdapter getAdapter(String mapperAdapterId);

}
