package com.github.jmodel.adapter.api.integration;

import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.Adapter;
import com.github.jmodel.adapter.spi.Term;

/**
 * Integrator adapter
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class IntegratorAdapter extends Adapter {

	@Override
	public Term getItemTerm() {
		return tfs.getTerm(AdapterTerms.INTEGRATOR_ADAPTER);
	}

	//

	public abstract void dispatch();
}
