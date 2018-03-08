package com.github.jmodel.adapter.api;

import com.github.jmodel.adapter.api.config.ConfigurationAware;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class Initializable implements ConfigurationAware {

	protected Boolean inited = false;

	public final boolean isInited() {
		return inited;
	}

	protected void setInited(boolean inited) {
		this.inited = inited;
	}

	protected abstract void init();
}
