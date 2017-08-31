package com.github.jmodel.adapter.api.search;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.api.Adapter;

/**
 * Searcher adapter
 * 
 * @author jianni@hotmail.com
 *
 */
public interface SearcherAdapter extends Adapter {

	public void index(String index, String doc) throws AdapterException;

	public String search(String index, String query) throws AdapterException;
}
