package com.github.jmodel.adapter.api.log;

import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.Adapter;
import com.github.jmodel.adapter.spi.Term;

/**
 * Logger adapter is usually used in enterprise application. It aims at complex
 * log requirement.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class LoggerAdapter extends Adapter {

	@Override
	public Term getItemTerm() {
		return tfs.getTerm(AdapterTerms.LOGGER_ADAPTER);
	}

	public abstract LoggerWrapper<?> getLoggerWrapper(String clzName);

}
