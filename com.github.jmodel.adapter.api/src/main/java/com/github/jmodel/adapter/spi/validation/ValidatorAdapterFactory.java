package com.github.jmodel.adapter.spi.validation;

import com.github.jmodel.adapter.api.validation.ValidatorAdapter;

/**
 * Validator adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface ValidatorAdapterFactory {

	public ValidatorAdapter getAdapter(String validatorAdapterId);

}
