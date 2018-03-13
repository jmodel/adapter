package com.github.jmodel.adapter;

import java.io.Serializable;

import com.github.jmodel.adapter.api.Facade;
import com.github.jmodel.adapter.api.integration.IntegratorAdapter;
import com.github.jmodel.adapter.api.integration.IntegratorAdapterFactoryService;
import com.github.jmodel.adapter.spi.Term;

/**
 * Public API for integration.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class Integrator extends Facade<IntegratorAdapter> {

	private final static IntegratorAdapterFactoryService _integrator_sp = IntegratorAdapterFactoryService.getInstance();

	private Integrator(IntegratorAdapter integratorAdapter) {
		this.adapter = integratorAdapter;
	}

	//

	public static Integrator getIntegrator() {
		return getIntegrator(null);
	}

	public static Integrator getIntegrator(Term adapterTerm) {
		IntegratorAdapter integratorAdapter = _integrator_sp
				.getAdapter(getTermText(tfs.getTerm(AdapterTerms.INTEGRATOR_ADAPTER), adapterTerm));
		Integrator integrator = fm.getFacade(integratorAdapter);
		if (integrator != null) {
			return integrator;
		}
		synchronized (fm) {
			if (integrator == null) {
				integrator = new Integrator(integratorAdapter);
				fm.addFacade(integrator);
			}
			return integrator;
		}
	}

	//

	public void dispatch(String pointName, Serializable content) {
		adapter.dispatch();
	}

}
