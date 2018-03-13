package com.github.jmodel.adapter.impl.search;

import java.util.SortedMap;

import com.github.jmodel.adapter.api.search.SearcherAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.search.SearcherAdapterFactory;

/**
 * Searcher adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class SearcherAdapterFactoryImpl extends SearcherAdapterFactory {

	@Override
	protected void createSearcherAdapters(SortedMap<String, SearcherAdapter> map) {
		map.put(AdapterImplTerms.ES5_REST_SEARCHER, new ES5RestSearchAdapter());
	}

}
