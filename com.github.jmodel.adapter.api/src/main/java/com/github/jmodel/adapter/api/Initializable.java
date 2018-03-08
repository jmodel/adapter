package com.github.jmodel.adapter.api;

import com.github.jmodel.adapter.api.config.ConfigurationManager;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class Initializable {

	protected final static ConfigurationManager cm = ConfigurationManager.getInstance();

	protected Boolean inited = false;

	public final boolean isInited() {
		return inited;
	}

	protected void setInited(boolean inited) {
		this.inited = inited;
	}

	protected abstract void init();
}
