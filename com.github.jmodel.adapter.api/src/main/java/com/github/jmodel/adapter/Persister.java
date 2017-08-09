package com.github.jmodel.adapter;

import java.util.List;

public class Persister {

	public Long insert(final String persistenceName, final Long ownerId, final String json, final String... args) {
		return null;
	}

	public Long insertObject(final String persistenceName, final Long ownerId, final Object domainModel,
			final String... args) {
		return null;
	}

	public Long update(final String persistenceName, final Long id, final String json, final String... args) {
		return null;
	}

	public Long updateObject(final String persistenceName, final Long id, final Object domainModel,
			final String... args) {
		return null;
	}

	public String find(final String persistenceName, final Long id) {
		return null;
	}

	public <T> T findObject(final String persistenceName, final Long id, final Class<T> clz, final String... args) {
		return null;
	}

	public <T> List<T> findList(final String persistenceName, final String... args) {
		return null;
	}

	public void delete(final String persistenceName, final Long id) {

	}
}
