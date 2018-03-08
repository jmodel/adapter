package com.github.jmodel.adapter.spi.persistence;

import com.github.jmodel.adapter.api.persistence.PersisterAdapter;

/**
 * Persister adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface PersisterAdapterFactory {

	public PersisterAdapter getAdapter(String adapterId);

}
