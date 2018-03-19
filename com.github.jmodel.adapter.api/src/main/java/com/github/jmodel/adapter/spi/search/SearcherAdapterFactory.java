package com.github.jmodel.adapter.spi.search;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.search.SearcherAdapter;
import com.github.jmodel.adapter.spi.Factory;

/**
 * Searcher adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class SearcherAdapterFactory extends Factory<SearcherAdapter> {

	protected final void init() {
		map = new TreeMap<String, SearcherAdapter>();
		createSearcherAdapters(map);
	}

	protected abstract void createSearcherAdapters(SortedMap<String, SearcherAdapter> map);
}
