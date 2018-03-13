package com.github.jmodel.adapter.api.search;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.Adapter;
import com.github.jmodel.adapter.spi.Term;

/**
 * Searcher adapter
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class SearcherAdapter extends Adapter {

	@Override
	public Term getItemTerm() {
		return tfs.getTerm(AdapterTerms.SEARCHER_ADAPTER);
	}

	//

	public abstract void index(String index, String doc) throws AdapterException;

	public abstract String search(String index, String query) throws AdapterException;
}
