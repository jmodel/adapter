package com.github.jmodel.adapter.impl.validation;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.validation.ValidatorAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.validation.ValidatorAdapterFactory;

/**
 * Validator adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class ValidatorAdapterFactoryImpl implements ValidatorAdapterFactory {

	private SortedMap<String, ValidatorAdapter> map;

	public ValidatorAdapterFactoryImpl() {
		map = new TreeMap<String, ValidatorAdapter>();
		map.put(AdapterImplTerms.MODEL_VALIDATOR.toString(), new ValidatorAdapterImpl());
	}

	@Override
	public ValidatorAdapter getAdapter(String adapterId) {
		return map.get(adapterId);
	}

}
