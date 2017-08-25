package com.github.jmodel.adapter.impl.search;

import java.util.HashMap;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.NoOpResponseParser;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.common.util.NamedList;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.Searcher.Query;
import com.github.jmodel.adapter.api.AdapterFactoryService;
import com.github.jmodel.adapter.api.Config;
import com.github.jmodel.adapter.api.search.SearcherAdapter;

/**
 * Adapter to use solrj 5.
 * 
 * @author jianni@hotmail.com
 *
 */
public class Solr5SearcherAdapter implements SearcherAdapter {

	private final Map<String, SolrClient> solrQueryClientMap = new HashMap<String, SolrClient>();

	private static String clientType;
	private static String solrServerUrl;
	private static String zookeeperUrl;

	static {
		try {

			final Config c = AdapterFactoryService.getInstance().getConfig();

			clientType = c.getValue("search.solr.client.type");
			solrServerUrl = c.getValue("search.solr.server.url");
			zookeeperUrl = c.getValue("search.solr.zoo_keeper.url");

		} catch (Exception e) {

		}
	}

	@Override
	public String search(String indexName, Query query) throws AdapterException {

		try {

			final SolrClient solr = getClientForQuery(indexName);

			final String queryString = query.getQuery();
			final Integer start = query.getStart();
			final Integer rows = query.getRows();

			final SolrQuery solrQuery = new SolrQuery();
			if (query != null) {
				solrQuery.setQuery(queryString);
			}
			if (start != null) {
				solrQuery.setStart(start);
			}
			if (rows != null) {
				solrQuery.setRows(rows);
			}

			final QueryRequest req = new QueryRequest(solrQuery);

			final NoOpResponseParser rawJsonResponseParser = new NoOpResponseParser();
			rawJsonResponseParser.setWriterType("json");
			req.setResponseParser(rawJsonResponseParser);

			final NamedList<Object> resp = solr.request(req);
			return (String) resp.get("response");

		} catch (Exception e) {
			throw new AdapterException("Failed to search", e);
		}

	}

	private SolrClient getClientForQuery(final String indexName) {

		SolrClient solr = solrQueryClientMap.get(indexName);
		if (solr == null) {

			if (clientType.equals("httpSolrClient")) {
				solr = new HttpSolrClient(solrServerUrl + "/" + indexName);
			} else {
				solr = new CloudSolrClient(zookeeperUrl);
				((CloudSolrClient) solr).setZkClientTimeout(5000);
				((CloudSolrClient) solr).setZkConnectTimeout(5000);
				((CloudSolrClient) solr).setDefaultCollection(indexName);
			}
			solrQueryClientMap.put(indexName, solr);
		}

		return solr;
	}

}
