package com.github.jmodel.adapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jmodel.adapter.api.AdapterFactoryService;
import com.github.jmodel.adapter.api.search.SearcherAdapter;

/**
 * Public API for search.
 * 
 * @author jianni@hotmail.com
 *
 */
public class Searcher {

	private final static SearcherAdapter searcherAdapter = AdapterFactoryService.getInstance()
			.getAdapter(SearcherAdapter.class);

	public static void index(String index, String doc) throws AdapterException {

		checkAdapter();

		searcherAdapter.index(index, doc);
	}

	public static String search(String index, String query) throws AdapterException {

		checkAdapter();

		return searcherAdapter.search(index, query);
	}

	public static Long count(final String indexName, final String json) {

		checkAdapter();

		return 0L;
	}

	public static String getId(final String indexName, final String json) {

		checkAdapter();

		return null;
	}

	private static void checkAdapter() {
		if (searcherAdapter == null) {
			throw new RuntimeException("Searcher adapter is not found, please check service provider configuration");
		}
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
