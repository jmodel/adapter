package com.github.jmodel.adapter.api.config;

import com.github.jmodel.adapter.api.Initializable;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class ConfigurationLoader extends Initializable {

	public final void load() {

		if (isInited()) {
			return;
		}

		synchronized (inited) {

			init();

			setInited(true);
		}
	}

}
