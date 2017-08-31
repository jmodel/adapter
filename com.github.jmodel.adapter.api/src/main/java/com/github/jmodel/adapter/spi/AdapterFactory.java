package com.github.jmodel.adapter.spi;

import com.github.jmodel.adapter.api.Adapter;

/**
 * adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface AdapterFactory {

	public <T extends Adapter> T getAdapter(Class<T> valueType);

}
