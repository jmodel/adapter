package com.github.jmodel.adapter.api.search;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.Searcher.Query;
import com.github.jmodel.adapter.api.Adapter;

/**
 * Searcher adapter
 * 
 * @author jianni@hotmail.com
 *
 */
public interface SearcherAdapter extends Adapter {

	public String search(String indexName, Query query) throws AdapterException;
}
