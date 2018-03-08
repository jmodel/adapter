package com.github.jmodel.adapter;

import com.github.jmodel.adapter.api.config.ConfigurationManager;
import com.github.jmodel.adapter.api.config.ConfiguratorAdapter;
import com.github.jmodel.adapter.api.config.ConfiguratorAdapterFactoryService;

/**
 * Adapter facade.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class Facade {

	protected final static FacadeManager facadeManager = FacadeManager.getFacadeManager();

	protected final static ConfigurationManager cm = ConfigurationManager.getInstance();

	protected final static ConfiguratorAdapterFactoryService _config_sp = ConfiguratorAdapterFactoryService
			.getInstance();

	protected String id;

	protected String getId() {
		return id;
	}

	protected static ConfiguratorAdapter<?> getConfiguratorAdapter(String configuratorAdapterId) {
		if (configuratorAdapterId == null) {
			return _config_sp.getAdapter();
		}

		return _config_sp.getAdapter(configuratorAdapterId);
	}

	protected static String getAdapterId(String adapterTypeName, String adapterName) {
		return (adapterName == null ? cm.getItemValue(AdapterTerms.ADAPTER, adapterTypeName)
				: cm.getItemValue(AdapterTerms.ADAPTER, adapterTypeName, adapterName));
	}
}
