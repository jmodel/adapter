package com.github.jmodel.adapter.api.log;

import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.Adapter;

/**
 * Logger adapter is usually used in enterprise application. It aims at complex
 * log requirement.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class LoggerAdapter extends Adapter {

	@Override
	public String getItemId() {
		return AdapterTerms.LOGGER.toString();
	}

	public abstract LoggerWrapper<?> getLoggerWrapper(String clzName);

}
