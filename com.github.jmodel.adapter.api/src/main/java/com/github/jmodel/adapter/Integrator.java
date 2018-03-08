package com.github.jmodel.adapter;

import java.io.Serializable;

import com.github.jmodel.adapter.api.Facade;
import com.github.jmodel.adapter.api.integration.IntegratorAdapter;
import com.github.jmodel.adapter.api.integration.IntegratorAdapterFactoryService;

/**
 * Public API for integration.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class Integrator extends Facade {

	private final static IntegratorAdapterFactoryService _integrator_sp = IntegratorAdapterFactoryService.getInstance();

	private IntegratorAdapter integratorAdapter;

	private Integrator(String id, IntegratorAdapter integratorAdapter) {
		if (integratorAdapter == null) {
			throw new RuntimeException("Integrator adapter is not found.");
		}
		this.id = id;
		this.integratorAdapter = integratorAdapter;
	}

	//

	public static Integrator getIntegrator() {
		return getIntegrator(null);
	}

	public static Integrator getIntegrator(String name) {
		String integratorAdapterId = getAdapterId(AdapterTerms.INTEGRATOR, name);
		Integrator integrator = facadeManager.getFacade(integratorAdapterId);
		if (integrator != null) {
			return integrator;
		}

		synchronized (facadeManager) {
			if (integrator == null) {
				integrator = new Integrator(integratorAdapterId, _integrator_sp.getAdapter(integratorAdapterId));
				facadeManager.addFacade(integrator);
			}
			return integrator;
		}
	}

	//

	public void dispatch(String pointName, Serializable content) {
		integratorAdapter.dispatch();
	}

}
