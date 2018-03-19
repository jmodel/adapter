package com.github.jmodel.adapter;

/**
 * Term is common language in certain domain. Any stakeholder should communicate
 * with each other with Term text. For adapter, all of term text are defined in
 * this interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface AdapterTerms {

	/**
	 * Local file system configurator is default. A configuration file named
	 * _config.xml is expected for adapter implementation. Some adapter
	 * implementation should be provided, like Cacher Adapter, Logger Adatper, etc.
	 */
	public final static String CONFIGURATOR_LFS = "CONFIGURATOR_LFS";

	//

	/**
	 * Adapter is a primary concept
	 */
	public final static String ADAPTER = "Adapter";

	//

	/**
	 * Cacher adapter
	 */
	public final static String CACHER_ADAPTER = "CacherAdapter";

	//

	/**
	 * Integrator adapter
	 */
	public final static String INTEGRATOR_ADAPTER = "IntegratorAdapter";

	//

	/**
	 * Logger adapter
	 */
	public final static String LOGGER_ADAPTER = "LoggerAdapter";

	/**
	 * The message regarding performance
	 */
	public final static String LOGGER_PFM = "LOGGER_PFM";

	//

	/**
	 * Mapper adapter
	 */
	public final static String MAPPER_ADAPTER = "MapperAdapter";

	//

	/**
	 * Persister Adapter
	 */
	public final static String PERSISTER_ADAPTER = "PersisterAdapter";

	//

	/**
	 * Searcher adapter
	 */
	public final static String SEARCHER_ADAPTER = "SearcherAdapter";

	//

	/**
	 * Validator adapter
	 */
	public final static String VALIDATOR_ADAPTER = "ValidatorAdapter";

}
