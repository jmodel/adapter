package com.github.jmodel.adapter.api.config;

public class MissingConfigException extends RuntimeException {

	private static final long serialVersionUID = 1941050729037744664L;

	public MissingConfigException() {
	}

	public MissingConfigException(String message) {
		super(message);
	}
}
