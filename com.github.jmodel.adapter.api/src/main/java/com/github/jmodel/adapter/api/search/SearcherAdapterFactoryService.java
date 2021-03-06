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
public final class SearcherAdapterFactoryService {

	private static SearcherAdapterFactoryService service;

	private ServiceLoader<SearcherAdapterFactory> loader;

	private SearcherAdapterFactoryService() {
		loader = ServiceLoader.load(SearcherAdapterFactory.class);
	}

	public static SearcherAdapterFactoryService getInstance() {
		if (service != null) {
			return service;
		}

		synchronized (SearcherAdapterFactoryService.class) {
			if (service == null) {
				service = new SearcherAdapterFactoryService();
			}
			return service;
		}
	}

	public SearcherAdapter getAdapter(String text) {

		SearcherAdapter searcherAdapter = null;

		Iterator<SearcherAdapterFactory> searcherAdapterFactorys = loader.iterator();
		while (searcherAdapter == null && searcherAdapterFactorys.hasNext()) {
			SearcherAdapterFactory searcherAdapterFactory = searcherAdapterFactorys.next();
			searcherAdapter = searcherAdapterFactory.create(text);
		}
		return searcherAdapter;
	}

}
