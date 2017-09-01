package com.github.jmodel.adapter.impl.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import com.github.jmodel.adapter.api.search.SearcherAdapter;
import com.github.jmodel.adapter.config.Configuration;
import com.github.jmodel.adapter.config.ConfigurationLoader;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public class ES5RestSearchAdapter implements SearcherAdapter {

	/**
	 * JDK Logger
	 */
	private final static Logger logger = Logger.getLogger(ES5RestSearchAdapter.class.getName());

	/**
	 * RestClient is official low-level client for Elasticsearch. Allows to
	 * communicate with an Elasticsearch cluster through http. Compatible with all
	 * elasticsearch versions.The RestClient class is thread-safe and ideally has
	 * the same lifecycle as the application that uses it. It is important that it
	 * gets closed when no longer needed so that all the resources used by it get
	 * properly released, as well as the underlying http client instance and its
	 * threads.
	 */
	private static RestClient restClient = getRestClient();

	@Override
	public void index(String indexName, String doc) throws AdapterException {

		checkRestClient();

		try {
			HttpEntity entity = new NStringEntity(doc, ContentType.APPLICATION_JSON);
			restClient.performRequestAsync("POST", indexName, Collections.<String, String>emptyMap(), entity,
					new ResponseListener() {
						@Override
						public void onSuccess(Response response) {
							System.out.println(response);
							logger.log(Level.INFO, () -> "Create search index successfully");
						}

						@Override
						public void onFailure(Exception e) {
							e.printStackTrace();
							logger.log(Level.WARNING, () -> "Failed to create search index");
						}
					});

		} catch (Exception e) {
			throw new AdapterException("Failed to create index", e);
		}

	}

	@Override
	public String search(String indexName, String query) throws AdapterException {

		checkRestClient();

		try {
			HttpEntity entity = new NStringEntity(query, ContentType.APPLICATION_JSON);
			Response response = restClient.performRequest("POST", indexName + "/_search",
					Collections.<String, String>emptyMap(), entity);
			return IOUtils.toString(response.getEntity().getContent(), "UTF-8");
		} catch (Exception e) {
			throw new AdapterException("Failed to search", e);
		}
	}

	private void checkRestClient() throws AdapterException {
		if (restClient == null) {

			try {
				restClient = RestClient.builder(new HttpHost("192.168.71.1", 9200, "http")).build();
				return;
			} catch (Exception e) {

			}
			throw new AdapterException("ES Rest Client is not ready");
		}
	}

	private static RestClient getRestClient() {

		try {
			Configuration config = ConfigurationLoader.getInstance().getConfiguration();
			if (config == null) {
				return null;
			}

			String hostInfoList = config.getValue("_es5_host_list", "Adapter", "SearcherAdapter");
			if (hostInfoList == null) {
				return null;
			}

			String[] hostInfoArray = StringUtils.split(hostInfoList, ",");
			if (hostInfoArray.length == 0) {
				return null;
			}

			List<HttpHost> httpHostList = new ArrayList<HttpHost>();

			for (int i = 0; i < hostInfoArray.length; i++) {
				String hostInfo = hostInfoArray[i];
				String[] hostParamArray = StringUtils.split(hostInfo, ":");
				if (hostParamArray.length != 3) {

					/*
					 * log warning message and ignore this
					 */
					logger.log(Level.WARNING, () -> "ES host list configuration is wrong");
					continue;
				}

				String hostName = hostParamArray[0];
				Integer hostPort = Integer.valueOf(hostParamArray[1]);
				String hostProtocal = hostParamArray[2];
				if (hostName == null || hostPort == null || hostProtocal == null) {
					/*
					 * log warning message and ignore this
					 */
					logger.log(Level.WARNING, () -> "ES host list configuration is wrong");
					continue;
				}
				httpHostList.add(new HttpHost(hostName, hostPort, hostProtocal));

			}
			if (httpHostList.size() == 0) {
				return null;
			}

			return RestClient.builder(httpHostList.toArray(new HttpHost[0])).build();

		} catch (Exception e) {
			logger.log(Level.WARNING, () -> "Rest Client is not ready");
			return null;
		}
	}

}
