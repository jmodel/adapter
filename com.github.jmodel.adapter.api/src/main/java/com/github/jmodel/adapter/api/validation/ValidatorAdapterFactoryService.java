package com.github.jmodel.adapter.api.validation;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.github.jmodel.adapter.spi.validation.ValidatorAdapterFactory;

/**
 * Validator adapter factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
public class ValidatorAdapterFactoryService {

	private static ValidatorAdapterFactoryService service;

	private ServiceLoader<ValidatorAdapterFactory> loader;

	private ValidatorAdapterFactoryService() {
		loader = ServiceLoader.load(ValidatorAdapterFactory.class);
	}

	public static synchronized ValidatorAdapterFactoryService getInstance() {
		if (service == null) {
			service = new ValidatorAdapterFactoryService();
		}
		return service;
	}

	public ValidatorAdapter getAdapter(String validatorAdapterId) {

		ValidatorAdapter validatorAdapter = null;

		Iterator<ValidatorAdapterFactory> validatorAdapterFactorys = loader.iterator();
		while (validatorAdapter == null && validatorAdapterFactorys.hasNext()) {
			ValidatorAdapterFactory validatorAdapterFactory = validatorAdapterFactorys.next();
			validatorAdapter = validatorAdapterFactory.getAdapter(validatorAdapterId);
		}
		return validatorAdapter;
	}

}
