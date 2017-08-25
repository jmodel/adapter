package com.github.jmodel.adapter.api;

/**
 * Constants
 * 
 * @author jianni@hotmail.com
 *
 */
public interface Const {

	public final static String VALIDATOR_ADAPTER_API = "com.github.jmodel.adapter.api.validation.ValidatorAdapter";

	public final static String MAPPER_ADAPTER_API = "com.github.jmodel.adapter.api.mapping.MapperAdapter";

	public final static String SEARCHER_ADAPTER_API = "com.github.jmodel.adapter.api.search.SearcherAdapter";

	public final static String PERSISTER_ADAPTER_API = "com.github.jmodel.adapter.api.persistence.PersistenterAdapter";

	public final static String INTEGRATOR_ADAPTER_API = "com.github.jmodel.adapter.api.integration.IntegratorAdapter";

	public final static String LOGGER_ADAPTER_API = "com.github.jmodel.adapter.api.log.LoggerAdapter";

	public final static String DEFAULT_VALIDATOR_ADAPTER_IMPL = "com.github.jmodel.adapter.impl.validation.ValidatorAdapterImpl";

	public final static String DEFAULT_MAPPER_ADAPTER_IMPL = "com.github.jmodel.adapter.impl.mapping.MapperAdapterImpl";

	public final static String DEFAULT_SEARCHER_ADAPTER_IMPL = "com.github.jmodel.adapter.impl.search.Solr5SearcherAdapter";

	public final static String DEFAULT_PERSISTER_ADAPTER_IMPL = "com.github.jmodel.adapter.impl.persistence.PersistenterAdapterImpl";

	public final static String DEFAULT_INTEGRATOR_ADAPTER_IMPL = "com.github.jmodel.adapter.impl.integration.IntegratorAdapterImpl";

	public final static String DEFAULT_LOGGER_ADAPTER_IMPL = "com.github.jmodel.adapter.impl.log.JDKLoggerAdapter";

}
