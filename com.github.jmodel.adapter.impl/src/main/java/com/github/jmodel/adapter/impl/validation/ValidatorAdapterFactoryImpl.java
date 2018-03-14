package com.github.jmodel.adapter.impl.validation;

import java.util.SortedMap;

import com.github.jmodel.adapter.api.validation.ValidatorAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.validation.ValidatorAdapterFactory;

/**
 * Validator adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class ValidatorAdapterFactoryImpl extends ValidatorAdapterFactory {

	@Override
	protected void createValidatorAdapters(SortedMap<String, ValidatorAdapter> map) {
		map.put(AdapterImplTerms.MODEL_VALIDATOR, new JModelValidatorAdapter());
	}

}
