package com.github.jmodel.adapter.spi;

import java.util.SortedMap;
import java.util.TreeMap;

import com.github.jmodel.adapter.api.Initializable;

public abstract class TermFactory extends Initializable {

	protected SortedMap<String, Term> map;

	public final Term getTerm(String text) {

		if (map == null) {
			doInit();
		}

		if (text != null) {
			return map.get(text);
		}
		return null;
	}

	@Override
	protected final void init() {
		map = new TreeMap<String, Term>();
		createTerms(map);

	}

	protected final Term create(String text) {
		return new Term(text);
	}

	protected abstract void createTerms(SortedMap<String, Term> map);

}
