package com.github.jmodel.adapter.api;

import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.config.ConfigurationAware;
import com.github.jmodel.adapter.spi.Term;

/**
 * Facade is one of the most important concept in adapter package. It aims at
 * providing a set of simple interface of some common features (implemented by
 * adapter) for business logic coder. The common features include:
 * <ul>
 * <li>Cache</li>
 * <li>Log</li>
 * <li>Model Mapping</li>
 * <li>DB Persistence</li>
 * <li>Search</li>
 * <li>Validation</li>
 * <li>etc. (extensible)</li>
 * </ul>
 * <p>
 * Using facade concept can bring the following benefits:
 * <ul>
 * <li>Common features can be handed over to specific experts</li>
 * <li>Business logic coder can focus on application domain really</li>
 * <li>The implementation of common features can be managed independently</li>
 * <li>Application has good portability</li>
 * </ul>
 * <p>
 * 
 * 
 * @author jianni@hotmail.com
 * @see com.github.jmodel.adapter.api.config.ConfigurationAware
 * @see com.github.jmodel.adapter.api.TermAware
 *
 * @param <T>
 *            adapter type
 */
public abstract class Facade<T extends Adapter> implements ConfigurationAware, TermAware {

	/**
	 * Facade manager is a single instance, used to manage facade instance.
	 */
	protected final static FacadeManager fm = FacadeManager.getFacadeManager();

	protected T adapter;

	protected T getAdapter() {
		return adapter;
	}

	/**
	 * Get adapter implementation term from configuration.
	 * 
	 * @param adapterTypeTerm
	 *            The term of adapter type, e.g. LoggerAdapter
	 * @param adapterTerm
	 *            The term of specific adapter, e.g. JDKLoggerAdapter
	 * @return adapter implementation term, e.g. MyJDKLoggerAdapter
	 */
	protected final static String getTermText(Term adapterTypeTerm, Term adapterTerm) {
		return (adapterTerm == null ? cm.getItemValue(AdapterTerms.ADAPTER, adapterTypeTerm.getText())
				: cm.getItemValue(AdapterTerms.ADAPTER, adapterTypeTerm.getText(), adapterTerm.getText()));
	}
}
