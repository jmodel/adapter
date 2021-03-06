package com.github.jmodel.adapter.api;

import com.github.jmodel.adapter.AdapterTerms;
import com.github.jmodel.adapter.api.config.Configurable;
import com.github.jmodel.adapter.spi.Term;

/**
 * The Adapter concept is used in mutable enterprise environment. For example, a
 * complex log mechnism required: transaction information need to be logged in
 * database, be dispatched to message queue at the same time, and be sent
 * someone by email. In such a situation, in order to keep code unchanged, it is
 * worth to introduce logger adapter concept. In addition, the third party
 * logger lib you choosed could be replaced by something else for some reason.
 * <p>
 * The Adapter concept is important for program portability. The implementation
 * of common features (e.g. log, validation, model mapping, integration) is
 * transparent for business application. In other words, you can use these
 * concepts and ignore the implementation really.
 * 
 * @author jianni@hotmail.com
 * @see com.github.jmodel.adapter.api.config.Configurable
 * @see com.github.jmodel.adapter.api.TermAware
 *
 */
public abstract class Adapter implements Configurable, TermAware {

	@Override
	public Term getRegionTerm() {
		return tfs.getTerm(AdapterTerms.ADAPTER);
	}
}
