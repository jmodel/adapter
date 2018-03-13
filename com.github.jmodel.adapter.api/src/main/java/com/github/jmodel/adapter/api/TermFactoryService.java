package com.github.jmodel.adapter.api;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.github.jmodel.adapter.spi.Term;
import com.github.jmodel.adapter.spi.TermFactory;

/**
 * Term factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class TermFactoryService {

	private static TermFactoryService service;

	private ServiceLoader<TermFactory> loader;

	private TermFactoryService() {
		loader = ServiceLoader.load(TermFactory.class);
	}

	static TermFactoryService getInstance() {
		if (service != null) {
			return service;
		}

		synchronized (TermFactoryService.class) {
			if (service == null) {
				service = new TermFactoryService();
			}
			return service;
		}
	}

	public Term getTerm(String termText) {

		Term term = null;
		Iterator<TermFactory> termFactorys = loader.iterator();
		while (term == null && termFactorys.hasNext()) {
			TermFactory termFactory = termFactorys.next();
			term = termFactory.getTerm(termText);
		}
		return term;
	}

}
