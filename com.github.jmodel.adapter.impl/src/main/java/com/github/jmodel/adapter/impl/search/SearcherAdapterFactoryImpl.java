package com.github.jmodel.adapter.impl.search;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.search.SearcherAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;
import com.github.jmodel.adapter.spi.search.SearcherAdapterFactory;

/**
 * Searcher adapter factory implementation.
 * 
 * @author jianni@hotmail.com
 *
 */
public class SearcherAdapterFactoryImpl implements SearcherAdapterFactory {

	private SortedMap<String, SearcherAdapter> map;

	public SearcherAdapterFactoryImpl() {
		map = new TreeMap<String, SearcherAdapter>();
		map.put(AdapterImplTerms.ES5_REST_SEARCHER.toString(), new ES5RestSearchAdapter());
	}

	@Override
	public SearcherAdapter getAdapter(String adapterId) {
		return map.get(adapterId);
	}

}
