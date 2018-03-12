package com.github.jmodel.adapter.api.integration;

import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.Adapter;

/**
 * Integrator adapter
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class IntegratorAdapter extends Adapter {

	@Override
	public String getItemId() {
		return AdapterTerms.INTEGRATOR.toString();
	}

	public abstract void dispatch();
}
