package com.github.jmodel.adapter.api.search;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.Adapter;

/**
 * Searcher adapter
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class SearcherAdapter extends Adapter {

	@Override
	public String getItemId() {
		return AdapterTerms.SEARCHER.toString();
	}

	//

	public abstract void index(String index, String doc) throws AdapterException;

	public abstract String search(String index, String query) throws AdapterException;
}
