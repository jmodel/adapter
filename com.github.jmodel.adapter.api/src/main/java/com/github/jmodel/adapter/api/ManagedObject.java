package com.github.jmodel.adapter.api;

public abstract class ManagedObject {

	private Integer manager;

	private Boolean monitored;

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public Boolean isMonitored() {
		return monitored;
	}

	public void setMonitored(Boolean monitored) {
		this.monitored = monitored;
	}

	//

	protected void checkLegality(int manager) {
		if (manager != this.manager) {
			throw new ManagementException("Expect a managed object");
		}
	}

	protected abstract void reportMe(MonitorInfo monitorInfo);
}
