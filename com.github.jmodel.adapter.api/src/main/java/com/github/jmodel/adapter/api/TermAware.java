package com.github.jmodel.adapter.api;

/**
 * A class implementes TermAware interface to be enforced using Term concept.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface TermAware {

	/**
	 * TermFactoryService is a single instance.
	 */
	public final static TermFactoryService tfs = TermFactoryService.getInstance();
}
