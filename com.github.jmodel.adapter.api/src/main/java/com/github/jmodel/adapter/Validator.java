package com.github.jmodel.adapter;

import com.github.jmodel.adapter.api.validation.ValidatorAdapter;
import com.github.jmodel.adapter.api.validation.ValidatorAdapterFactoryService;

/**
 * Public API for validation.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class Validator extends Facade {

	private final static ValidatorAdapterFactoryService _validator_sp = ValidatorAdapterFactoryService.getInstance();

	private ValidatorAdapter validatorAdapter;

	private Validator(String id, ValidatorAdapter validatorAdapter) {
		if (validatorAdapter == null) {
			throw new RuntimeException("Validator adapter is not found.");
		}
		this.id = id;
		this.validatorAdapter = validatorAdapter;
	}

	//

	public static Validator getValidator() {
		return getValidator(null);
	}

	public static Validator getValidator(String name) {
		String validatorAdapterId = getAdapterId(AdapterTerms.VALIDATOR, name);
		Validator validator = facadeManager.getFacade(validatorAdapterId);
		if (validator != null) {
			return validator;
		}

		synchronized (facadeManager) {
			if (validator == null) {
				validator = new Validator(validatorAdapterId, _validator_sp.getAdapter(validatorAdapterId));
				facadeManager.addFacade(validator);
			}
			return validator;
		}
	}

	//

	public <T> void check(T object, String validationName) throws AdapterException {
		validatorAdapter.check(object, validationName);
	}

}
