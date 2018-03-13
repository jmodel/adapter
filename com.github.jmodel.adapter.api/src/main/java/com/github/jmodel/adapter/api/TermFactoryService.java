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
public class TermFactoryService {

	private static TermFactoryService service;

	private ServiceLoader<TermFactory> loader;

	private TermFactoryService() {
		loader = ServiceLoader.load(TermFactory.class);
	}

	public static synchronized TermFactoryService getInstance() {
		if (service == null) {
			service = new TermFactoryService();
		}
		return service;
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
