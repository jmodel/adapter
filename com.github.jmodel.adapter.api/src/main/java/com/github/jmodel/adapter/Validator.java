package com.github.jmodel.adapter;

import com.github.jmodel.adapter.api.Facade;
import com.github.jmodel.adapter.api.validation.ValidatorAdapter;
import com.github.jmodel.adapter.api.validation.ValidatorAdapterFactoryService;
import com.github.jmodel.adapter.spi.Term;

/**
 * Simple validation facade.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class Validator extends Facade<ValidatorAdapter> {

	/**
	 * Validator adapter factory service
	 */
	private final static ValidatorAdapterFactoryService _validator_sp = ValidatorAdapterFactoryService.getInstance();

	private Validator(ValidatorAdapter validatorAdapter) {
		this.adapter = validatorAdapter;
	}

	//

	public static Validator getValidator() {
		return getValidator(null);
	}

	public static Validator getValidator(Term adapterTerm) {
		ValidatorAdapter validatorAdapter = _validator_sp
				.getAdapter(getTermText(tfs.getTerm(AdapterTerms.VALIDATOR_ADAPTER), adapterTerm));

		Validator validator = fm.getFacade(validatorAdapter);
		if (validator != null) {
			return validator;
		}

		synchronized (fm) {
			if (validator == null) {
				validator = new Validator(validatorAdapter);
				fm.addFacade(validator);
			}
			return validator;
		}
	}

	//

	public <T> void check(T object, String validationName) throws AdapterException {
		adapter.check(object, validationName);
	}

}
