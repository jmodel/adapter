package com.github.jmodel.adapter.api;

import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.config.Configurable;

/**
 * The Adapter concept is used in mutable business application context. For
 * example, a complex log mechnism required: transaction information need to be
 * logged in database, be dispatched to message queue at the same time, and be
 * sent someone by email. In such a situation, in order to keep code unchanged,
 * it is worth to introduce logger adapter concept. In addition, the third party
 * logger lib you choosed could be replaced by something else for some reason.
 * <p>
 * The Adapter concept is important for program portability. The implementation
 * of common features (e.g. log, validation, model mapping, integration) is
 * transparent for business application. In other words, you can use these
 * concepts and ignore the implementation really.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class Adapter implements Configurable {

	@Override
	public String getRegionId() {
		return AdapterTerms.ADAPTER;
	}
}
