package com.github.jmodel.adapter.spi;

import java.util.SortedMap;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public class AdapterTermFactory extends TermFactory {

	@Override
	protected void createTerms(SortedMap<String, Term> map) {
		map.put("Adapter", create("Adapter"));
		map.put("CacherAdapter", create("CacherAdapter"));
		map.put("IntegratorAdapter", create("IntegratorAdapter"));
		map.put("LoggerAdapter", create("LoggerAdapter"));
		map.put("MapperAdapter", create("MapperAdapter"));
		map.put("PersisterAdapter", create("PersisterAdapter"));
		map.put("SearcherAdapter", create("SearcherAdapter"));
		map.put("ValidatorAdapter", create("ValidatorAdapter"));
	}

}
