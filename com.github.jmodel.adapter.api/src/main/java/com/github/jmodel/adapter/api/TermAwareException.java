package com.github.jmodel.adapter.api;

/**
 * Term is common language of specified stakeholders. If talk with each other in
 * strange language, TermAwareException will be thrown.
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
