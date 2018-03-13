package com.github.jmodel.adapter.spi;

import java.util.SortedMap;

import com.github.jmodel.adapter.api.Initializable;
import com.github.jmodel.adapter.api.TermAware;

/**
 * Adapter factory interface.
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class AdapterFactory<T> extends Initializable implements TermAware {

	protected SortedMap<String, T> map;

	public final T getAdapter(String text) {

		if (map == null) {
			doInit();
		}

		if (text != null) {
			return map.get(text);
		}
		return null;
	}

}
