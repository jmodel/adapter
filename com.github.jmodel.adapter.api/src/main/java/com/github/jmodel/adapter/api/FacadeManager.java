package com.github.jmodel.adapter.api;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public final class FacadeManager {

	private Map<Adapter, Facade<?>> facadeMap = new HashMap<Adapter, Facade<?>>();

	private static FacadeManager facadeManager;

	private FacadeManager() {

	}

	public final static FacadeManager getFacadeManager() {
		if (facadeManager != null) {
			return facadeManager;
		}

		synchronized (FacadeManager.class) {
			if (facadeManager == null) {
				facadeManager = new FacadeManager();
			}
			return facadeManager;
		}

	}

	//

	@SuppressWarnings("unchecked")
	public <T> T getFacade(Adapter adapter) {
		return (T) facadeMap.get(adapter);
	}

	public synchronized void addFacade(Facade<?> facade) {
		facadeMap.put(facade.getAdapter(), facade);
	}
}
