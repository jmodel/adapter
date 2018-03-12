package com.github.jmodel.adapter.api;

/**
 * Terms is common language of all stakeholders.
 * 
 * @author jianni@hotmail.com
 *
 */
public class TermAwareException extends RuntimeException {

	private static final long serialVersionUID = 8266322551659982022L;

	public TermAwareException() {
	}

	public TermAwareException(String message) {
		super(message);
	}
}
