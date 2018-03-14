package com.github.jmodel.adapter.api.config;

/**
 * MissingConfigException
 * 
 * @author jianni@hotmail.com
 *
 */
public class MissingConfigException extends RuntimeException {

	private static final long serialVersionUID = 1941050729037744664L;

	public MissingConfigException() {
	}

	public MissingConfigException(String message) {
		super(message);
	}
}
