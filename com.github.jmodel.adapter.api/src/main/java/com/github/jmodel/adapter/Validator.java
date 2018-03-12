package com.github.jmodel.adapter;

import com.github.jmodel.adapter.api.Facade;
import com.github.jmodel.adapter.api.Term;
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

	public static Validator getValidator(Term t) {
		String validatorAdapterId = getAdapterId(AdapterTerms.VALIDATOR, t);
		Validator validator = fm.getFacade(validatorAdapterId);
		if (validator != null) {
			return validator;
		}

		synchronized (fm) {
			if (validator == null) {
				validator = new Validator(validatorAdapterId, _validator_sp.getAdapter(validatorAdapterId));
				fm.addFacade(validator);
			}
			return validator;
		}
	}

	//

	public <T> void check(T object, String validationName) throws AdapterException {
		validatorAdapter.check(object, validationName);
	}

}
