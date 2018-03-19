package com.github.jmodel.adapter.api;

public abstract class ManagedObject {

	private int manager;

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	protected void checkLegality(int manager) {
		if (manager != this.manager) {
			throw new ManagementException("Expect a managed object");
		}
	}
}
