package com.github.jmodel.adapter.spi;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.jmodel.adapter.api.Adapter;
import com.github.jmodel.adapter.api.Config;
import com.github.jmodel.adapter.api.Const;
import com.github.jmodel.adapter.api.integration.IntegratorAdapter;
import com.github.jmodel.adapter.api.log.LoggerAdapter;
import com.github.jmodel.adapter.api.mapping.MapperAdapter;
import com.github.jmodel.adapter.api.persistence.PersisterAdapter;
import com.github.jmodel.adapter.api.search.SearcherAdapter;
import com.github.jmodel.adapter.api.validation.ValidatorAdapter;

/**
 * adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public class AdapterFactory {

	/**
	 * JDK Logger
	 */
	private final static Logger logger = Logger.getLogger(AdapterFactory.class.getName());

	private final static String CONFIG_API = "com.github.jmodel.adapter.api.Config";

	private final static String DEFAULT_CONFIG_IMPL = "com.github.jmodel.adapter.impl.ConfigImpl";

	private final Properties properties = new Properties();

	protected Config config;

	protected final Map<Class<?>, Adapter> adapterMap = new HashMap<Class<?>, Adapter>();

	public AdapterFactory() {

		try {
			properties.load(this.getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			logger.log(Level.WARNING, e, () -> "Failed to find config properties file");
		}

		String configURI = properties.getProperty(CONFIG_API, DEFAULT_CONFIG_IMPL);

		try {
			config = (Config) Class.forName(configURI).newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Config implementation is not found");
		}

		adapterMap.put(ValidatorAdapter.class,
				getInstance(config.getValue(Const.VALIDATOR_ADAPTER_API), Const.DEFAULT_VALIDATOR_ADAPTER_IMPL));
		adapterMap.put(MapperAdapter.class,
				getInstance(config.getValue(Const.MAPPER_ADAPTER_API), Const.DEFAULT_MAPPER_ADAPTER_IMPL));
		adapterMap.put(SearcherAdapter.class,
				getInstance(config.getValue(Const.SEARCHER_ADAPTER_API), Const.DEFAULT_SEARCHER_ADAPTER_IMPL));
		adapterMap.put(PersisterAdapter.class,
				getInstance(config.getValue(Const.PERSISTER_ADAPTER_API), Const.DEFAULT_PERSISTER_ADAPTER_IMPL));
		adapterMap.put(IntegratorAdapter.class,
				getInstance(config.getValue(Const.INTEGRATOR_ADAPTER_API), Const.DEFAULT_INTEGRATOR_ADAPTER_IMPL));
		adapterMap.put(LoggerAdapter.class,
				getInstance(config.getValue(Const.LOGGER_ADAPTER_API), Const.DEFAULT_LOGGER_ADAPTER_IMPL));
	}

	public Config getConfig() {
		return config;
	}

	@SuppressWarnings("unchecked")
	public <T extends Adapter> T getAdapter(Class<T> valueType) {
		return (T) adapterMap.get(valueType);
	}

	protected Adapter getInstance(String impl, String defaultImpl) {

		try {
			Adapter adapter = null;
			if (impl == null) {
				adapter = (Adapter) Class.forName(defaultImpl).newInstance();
			} else {
				adapter = (Adapter) Class.forName(impl).newInstance();
			}

			return adapter;
		} catch (Exception e) {
			logger.log(Level.WARNING, e, () -> "Failed to create new instance for " + impl);
			return null;
		}
	}
}
