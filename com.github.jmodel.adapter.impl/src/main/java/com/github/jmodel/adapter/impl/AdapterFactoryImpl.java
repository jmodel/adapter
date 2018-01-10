package com.github.jmodel.adapter.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.jmodel.adapter.api.Adapter;
import com.github.jmodel.adapter.api.Const;
import com.github.jmodel.adapter.api.cache.CacherAdapter;
import com.github.jmodel.adapter.api.integration.IntegratorAdapter;
import com.github.jmodel.adapter.api.log.LoggerAdapter;
import com.github.jmodel.adapter.api.mapping.MapperAdapter;
import com.github.jmodel.adapter.api.persistence.PersisterAdapter;
import com.github.jmodel.adapter.api.search.SearcherAdapter;
import com.github.jmodel.adapter.api.validation.ValidatorAdapter;
import com.github.jmodel.adapter.spi.AdapterFactory;
import com.github.jmodel.config.Configuration;
import com.github.jmodel.config.ConfigurationLoader;

/**
 * adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public class AdapterFactoryImpl implements AdapterFactory {

	protected final Map<Class<?>, Adapter> adapterMap = new HashMap<Class<?>, Adapter>();

	public AdapterFactoryImpl() {

		//////////////// default adapter implementation ///////////////////

		Configuration configuration = null;
		try {
			configuration = ConfigurationLoader.getInstance().getConfiguration();
		} catch (Exception e) {

		}

		adapterMap.put(ValidatorAdapter.class, createAdapter(configuration.getValue("Adapter", "ValidatorAdapter"),
				Const.DEFAULT_VALIDATOR_ADAPTER_IMPL));
		adapterMap.put(MapperAdapter.class,
				createAdapter(configuration.getValue("Adapter", "MapperAdapter"), Const.DEFAULT_MAPPER_ADAPTER_IMPL));
		adapterMap.put(SearcherAdapter.class, createAdapter(configuration.getValue("Adapter", "SearcherAdapter"),
				Const.DEFAULT_SEARCHER_ADAPTER_IMPL));
		adapterMap.put(PersisterAdapter.class, createAdapter(configuration.getValue("Adapter", "PersisterAdapter"),
				Const.DEFAULT_PERSISTER_ADAPTER_IMPL));
		adapterMap.put(IntegratorAdapter.class, createAdapter(configuration.getValue("Adapter", "IntegratorAdapter"),
				Const.DEFAULT_INTEGRATOR_ADAPTER_IMPL));
		adapterMap.put(LoggerAdapter.class,
				createAdapter(configuration.getValue("Adapter", "LoggerAdapter"), Const.DEFAULT_LOGGER_ADAPTER_IMPL));
		adapterMap.put(CacherAdapter.class,
				createAdapter(configuration.getValue("Adapter", "CacherAdapter"), Const.DEFAULT_CACHER_ADAPTER_IMPL));
	}

	@SuppressWarnings("unchecked")
	public <T extends Adapter> T getAdapter(Class<T> valueType) {
		return (T) adapterMap.get(valueType);
	}

	/**
	 * 
	 * 
	 * @param impl
	 *            adapter implementation
	 * @param defaultImpl
	 *            default adapter implementation
	 * @return Adapter
	 */
	private Adapter createAdapter(String impl, String defaultImpl) {

		try {
			return (Adapter) Class.forName(impl).newInstance();
		} catch (Exception e) {
			try {
				return (Adapter) Class.forName(defaultImpl).newInstance();
			} catch (Exception e1) {
				throw new RuntimeException("Adapter default impl is not found", e1);
			}
		}
	}

}
