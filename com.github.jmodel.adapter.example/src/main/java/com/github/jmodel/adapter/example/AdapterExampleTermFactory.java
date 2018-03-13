package com.github.jmodel.adapter.example;

import java.util.SortedMap;

import com.github.jmodel.adapter.spi.Term;
import com.github.jmodel.adapter.spi.TermFactory;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public class AdapterExampleTermFactory extends TermFactory {

	@Override
	protected void createTerms(SortedMap<String, Term> map) {
		map.put("EXAMPLE_CONFIG", create("EXAMPLE_CONFIG"));
		map.put("INSERT_USER", create("INSERT_USER"));
	}

}
