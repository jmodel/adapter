package com.github.jmodel.adapter;

import com.github.jmodel.adapter.api.AdapterFactoryService;
import com.github.jmodel.adapter.api.validation.ValidatorAdapter;

/**
 * Public API for validation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class Validator {

	private final static ValidatorAdapter validatorAdapter = AdapterFactoryService.getInstance()
			.getAdapter(ValidatorAdapter.class);

	public <T> void check(T object, String validationName) {
		checkAdapter();
	}

	private static void checkAdapter() {
		if (validatorAdapter == null) {
			throw new RuntimeException("Validator adapter is not found, please check service provider configuration");
		}
	}
}
