package com.github.jmodel.adapter.api.validation;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.Adapter;

/**
 * Validator adatper
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class ValidatorAdapter extends Adapter {

	@Override
	public String getItemId() {
		return AdapterTerms.VALIDATOR.toString();
	}

	//

	public abstract <T> T check(Object sourceObj, String validatingURI) throws AdapterException;

	// public <T> T check(Object sourceObj, String validatingURI, Map<String,
	// Object> argsMap, Class<T> valueType)
	// throws AdapterException;
}
