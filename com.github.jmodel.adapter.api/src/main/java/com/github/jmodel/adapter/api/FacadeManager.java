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

	private Map<String, Facade> facadeMap = new HashMap<String, Facade>();

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
	public <T> T getFacade(String id) {
		return (T) facadeMap.get(id);
	}

	public synchronized void addFacade(Facade facade) {
		facadeMap.put(facade.getId(), facade);
	}
}
