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

	protected final void setInited(boolean inited) {
		this.inited = inited;
	}

	public final void doInit() {

		if (isInited()) {
			return;
		}

		synchronized (inited) {

			init();

			setInited(true);
		}
	}

	protected abstract void init();
}
