package com.github.jmodel.adapter.spi.search;

import com.github.jmodel.adapter.api.search.SearcherAdapter;

/**
 * Searcher adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public interface SearcherAdapterFactory {

	public SearcherAdapter getAdapter(String searcherAdapterId);

}
