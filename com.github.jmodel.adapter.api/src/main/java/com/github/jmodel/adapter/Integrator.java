package com.github.jmodel.adapter;

import java.io.Serializable;

import com.github.jmodel.adapter.api.AdapterFactoryService;
import com.github.jmodel.adapter.api.integration.IntegratorAdapter;

/**
 * Public API for integration.
 * 
 * @author jianni@hotmail.com
 *
 */
public class Integrator {

	private final static IntegratorAdapter integratorAdapter = AdapterFactoryService.getInstance()
			.getAdapter(IntegratorAdapter.class);

	public static void dispatch(String pointName, Serializable content) {
		checkAdapter();
	}

	private static void checkAdapter() {
		if (integratorAdapter == null) {
			throw new RuntimeException("Integrator adapter is not found, please check service provider configuration");
		}
	}
}
