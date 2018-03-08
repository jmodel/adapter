package com.github.jmodel.adapter.impl.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseListener;
import org.elasticsearch.client.RestClient;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.config.ConfigurationManager;
import com.github.jmodel.adapter.api.config.IllegalFormatException;
import com.github.jmodel.adapter.api.config.MissingConfigException;
import com.github.jmodel.adapter.api.search.SearcherAdapter;
import com.github.jmodel.adapter.impl.AdapterImplTerms;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public class ES5RestSearchAdapter extends SearcherAdapter {

	/**
	 * RestClient is official low-level client for Elasticsearch. Allows to
	 * communicate with an Elasticsearch cluster through http. Compatible with all
	 * elasticsearch versions.The RestClient class is thread-safe and ideally has
	 * the same lifecycle as the application that uses it. It is important that it
	 * gets closed when no longer needed so that all the resources used by it get
	 * properly released, as well as the underlying http client instance and its
	 * threads.
	 */
	private RestClient restClient;

	@Override
	public void index(String indexName, String doc) throws AdapterException {

		try {
			HttpEntity entity = new NStringEntity(doc, ContentType.APPLICATION_JSON);
			getRestClient().performRequestAsync("POST", indexName, Collections.<String, String>emptyMap(), entity,
					new ResponseListener() {
						@Override
						public void onSuccess(Response response) {

						}

						@Override
						public void onFailure(Exception e) {

						}
					});

		} catch (Exception e) {
			throw new AdapterException("Failed to create index", e);
		}

	}

	@Override
	public String search(String indexName, String query) throws AdapterException {

		try {
			HttpEntity entity = new NStringEntity(query, ContentType.APPLICATION_JSON);
			Response response = getRestClient().performRequest("POST", indexName + "/_search",
					Collections.<String, String>emptyMap(), entity);
			return IOUtils.toString(response.getEntity().getContent(), "UTF-8");
		} catch (Exception e) {
			throw new AdapterException("Failed to search", e);
		}
	}

	private RestClient getRestClient() throws MissingConfigException, IllegalFormatException {

		if (restClient != null) {
			return restClient;
		}

		synchronized (ConfigurationManager.getInstance()) {

			String hostInfoList = ConfigurationManager.getInstance().getPropertyValue(AdapterImplTerms.ES5_HOST,
					AdapterTerms.ADAPTER, AdapterTerms.SEARCHER);
			if (hostInfoList == null) {
				throw new MissingConfigException("ES5 host info is not found in configuration.");
			}

			String[] hostInfoArray = StringUtils.split(hostInfoList, ",");
			List<HttpHost> httpHostList = new ArrayList<HttpHost>();
			for (int i = 0; i < hostInfoArray.length; i++) {
				String hostInfo = hostInfoArray[i];
				String[] hostParamArray = StringUtils.split(hostInfo, ":");
				if (hostParamArray.length != 3) {
					continue;
				}

				String hostName = hostParamArray[0];
				Integer hostPort = Integer.valueOf(hostParamArray[1]);
				String hostProtocal = hostParamArray[2];
				if (hostName == null || hostPort == null || hostProtocal == null) {
					continue;
				}
				httpHostList.add(new HttpHost(hostName, hostPort, hostProtocal));
			}

			if (httpHostList.size() == 0) {
				throw new IllegalFormatException(
						"Expect <host>:<port>:<protocal>,<host>:<port>:<protocal>,... instead of " + hostInfoList);
			}
			restClient = RestClient.builder(httpHostList.toArray(new HttpHost[0])).build();

			return restClient;
		}

	}

}
