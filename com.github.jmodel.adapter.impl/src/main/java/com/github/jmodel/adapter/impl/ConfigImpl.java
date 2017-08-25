package com.github.jmodel.adapter.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.jmodel.adapter.api.Config;
import com.github.jmodel.adapter.api.Const;

/**
 * Default config implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class ConfigImpl implements Config {

	private Map<String, String> adapterConfigMap = new HashMap<String, String>();

	public ConfigImpl() {

		adapterConfigMap.put(Const.VALIDATOR_ADAPTER_API, Const.DEFAULT_VALIDATOR_ADAPTER_IMPL);
		adapterConfigMap.put(Const.MAPPER_ADAPTER_API, Const.DEFAULT_MAPPER_ADAPTER_IMPL);
		adapterConfigMap.put(Const.SEARCHER_ADAPTER_API, Const.DEFAULT_SEARCHER_ADAPTER_IMPL);
		adapterConfigMap.put(Const.PERSISTER_ADAPTER_API, Const.DEFAULT_PERSISTER_ADAPTER_IMPL);
		adapterConfigMap.put(Const.INTEGRATOR_ADAPTER_API, Const.DEFAULT_INTEGRATOR_ADAPTER_IMPL);
		adapterConfigMap.put(Const.LOGGER_ADAPTER_API, Const.DEFAULT_LOGGER_ADAPTER_IMPL);

	}

	@Override
	public String getValue(String key) {
		return adapterConfigMap.get(key);
	}

}
