package com.github.jmodel.adapter.api;

import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.config.ConfigurationAware;

/**
 * Adapter facade.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class Facade implements ConfigurationAware {

	protected final static FacadeManager facadeManager = FacadeManager.getFacadeManager();

	protected String id;

	protected String getId() {
		return id;
	}

	protected static String getAdapterId(String adapterTypeName, String adapterName) {
		return (adapterName == null ? cm.getItemValue(AdapterTerms.ADAPTER, adapterTypeName)
				: cm.getItemValue(AdapterTerms.ADAPTER, adapterTypeName, adapterName));
	}
}
