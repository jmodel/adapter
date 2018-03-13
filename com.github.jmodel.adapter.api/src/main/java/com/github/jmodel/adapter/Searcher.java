package com.github.jmodel.adapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.adapter.api.Facade;
import com.github.jmodel.adapter.api.search.SearcherAdapter;
import com.github.jmodel.adapter.api.search.SearcherAdapterFactoryService;
import com.github.jmodel.adapter.spi.Term;

/**
 * Public API for search.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class Searcher extends Facade<SearcherAdapter> {

	private final static SearcherAdapterFactoryService _searcher_sp = SearcherAdapterFactoryService.getInstance();

	private Searcher(SearcherAdapter searcherAdapter) {
		this.adapter = searcherAdapter;
	}

	//

	public static Searcher getSearcher() {
		return getSearcher(null);
	}

	public static Searcher getSearcher(Term adapterTerm) {
		SearcherAdapter searcherAdapter = _searcher_sp
				.getAdapter(getTermText(tfs.getTerm(AdapterTerms.SEARCHER_ADAPTER), adapterTerm));
		Searcher searcher = fm.getFacade(searcherAdapter);
		if (searcher != null) {
			return searcher;
		}
		synchronized (fm) {
			if (searcher == null) {
				searcher = new Searcher(searcherAdapter);
				fm.addFacade(searcher);
			}
			return searcher;
		}
	}

	//

	public void index(String index, String doc) throws AdapterException {
		adapter.index(index, doc);
	}

	public String search(String index, String query) throws AdapterException {
		return adapter.search(index, query);
	}

	public Long count(final String indexName, final String json) {
		return 0L;
	}

	public String getId(final String indexName, final String json) {
		return null;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Query {

		private String query;

		private Integer start;

		private Integer rows;

		private String sortField;

		private String order;

		public String getQuery() {
			return query;
		}

		public void setQuery(String query) {
			this.query = query;
		}

		public Integer getStart() {
			return start;
		}

		public void setStart(Integer start) {
			this.start = start;
		}

		public Integer getRows() {
			return rows;
		}

		public void setRows(Integer rows) {
			this.rows = rows;
		}

		public String getSortField() {
			return sortField;
		}

		public void setSortField(String sortField) {
			this.sortField = sortField;
		}

		public String getOrder() {
			return order;
		}

		public void setOrder(String order) {
			this.order = order;
		}
	}

}
