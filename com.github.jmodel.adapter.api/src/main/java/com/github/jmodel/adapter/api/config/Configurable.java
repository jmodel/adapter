package com.github.jmodel.adapter.api.config;

import com.github.jmodel.adapter.spi.Term;

/**
 * 
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public interface Configurable extends ConfigurationAware {

	public Term getRegionTerm();

	public Term getItemTerm();

}
