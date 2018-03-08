package com.github.jmodel.adapter.spi.integration;

import com.github.jmodel.adapter.api.integration.IntegratorAdapter;

/**
 * Integrator adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface IntegratorAdapterFactory {

	public IntegratorAdapter getAdapter(String integratorAdapterId);

}
