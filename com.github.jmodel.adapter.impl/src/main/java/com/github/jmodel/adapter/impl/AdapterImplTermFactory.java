package com.github.jmodel.adapter.impl;

import java.util.SortedMap;

import com.github.jmodel.adapter.spi.Term;
import com.github.jmodel.adapter.spi.TermFactory;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public final class AdapterImplTermFactory extends TermFactory {

	@Override
	protected void createTerms(SortedMap<String, Term> map) {
		map.put("LFS_CONFIGURATOR", create("LFS_CONFIGURATOR"));
		map.put("JCS_CACHER", create("JCS_CACHER"));
		map.put("INTEGRATION_CLIENT", create("INTEGRATION_CLIENT"));
		map.put("JDK_LOGGER", create("JDK_LOGGER"));
		map.put("JMODEL_MAPPER", create("JMODEL_MAPPER"));
		map.put("MYBATIS_PERSISTER", create("MYBATIS_PERSISTER"));
		map.put("ES5_REST_SEARCHER", create("ES5_REST_SEARCHER"));
		map.put("ES5_HOST", create("ES5_HOST"));
		map.put("MODEL_VALIDATOR", create("MODEL_VALIDATOR"));

	}

}
