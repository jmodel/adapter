package com.github.jmodel.adapter.api.search;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.github.jmodel.adapter.spi.search.SearcherAdapterFactory;

/**
 * Searcher adapter factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
public class SearcherAdapterFactoryService {

	private static SearcherAdapterFactoryService service;

	private ServiceLoader<SearcherAdapterFactory> loader;

	private SearcherAdapterFactoryService() {
		loader = ServiceLoader.load(SearcherAdapterFactory.class);
	}

	public static synchronized SearcherAdapterFactoryService getInstance() {
		if (service == null) {
			service = new SearcherAdapterFactoryService();
		}
		return service;
	}

	public SearcherAdapter getAdapter(String text) {

		SearcherAdapter searcherAdapter = null;

		Iterator<SearcherAdapterFactory> searcherAdapterFactorys = loader.iterator();
		while (searcherAdapter == null && searcherAdapterFactorys.hasNext()) {
			SearcherAdapterFactory searcherAdapterFactory = searcherAdapterFactorys.next();
			searcherAdapter = searcherAdapterFactory.getAdapter(text);
		}
		return searcherAdapter;
	}

}
