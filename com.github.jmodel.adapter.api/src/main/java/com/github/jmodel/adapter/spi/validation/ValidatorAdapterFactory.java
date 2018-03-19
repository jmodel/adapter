package com.github.jmodel.adapter.spi.validation;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.validation.ValidatorAdapter;
import com.github.jmodel.adapter.spi.Factory;

/**
 * Validator adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class ValidatorAdapterFactory extends Factory<ValidatorAdapter> {

	protected final void init() {
		map = new TreeMap<String, ValidatorAdapter>();
		createValidatorAdapters(map);
	}

	protected abstract void createValidatorAdapters(SortedMap<String, ValidatorAdapter> map);
}
