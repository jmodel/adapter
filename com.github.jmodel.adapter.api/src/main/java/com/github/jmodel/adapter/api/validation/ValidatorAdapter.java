package com.github.jmodel.adapter.api.validation;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.Adapter;
import com.github.jmodel.adapter.spi.Term;

/**
 * Validator adatper
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class ValidatorAdapter extends Adapter {

	@Override
	public Term getItemTerm() {
		return tfs.getTerm(AdapterTerms.VALIDATOR_ADAPTER);
	}

	//

	public abstract <T> T check(Object sourceObj, String validatingURI) throws AdapterException;

	// public <T> T check(Object sourceObj, String validatingURI, Map<String,
	// Object> argsMap, Class<T> valueType)
	// throws AdapterException;
}
