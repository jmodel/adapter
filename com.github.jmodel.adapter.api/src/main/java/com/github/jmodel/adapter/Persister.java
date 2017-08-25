package com.github.jmodel.adapter;

import java.util.List;

import com.github.jmodel.adapter.api.AdapterFactoryService;
import com.github.jmodel.adapter.api.persistence.PersisterAdapter;

/**
 * Public API for persistence.
 * 
 * @author jianni@hotmail.com
 *
 */
public class Persister {

	private final static PersisterAdapter persisterAdapter = AdapterFactoryService.getInstance()
			.getAdapter(PersisterAdapter.class);

	public static <S, T> Long insert(S session, String persistenceName, String json, Class<T> valueType)
			throws AdapterException {

		checkAdapter();

		return persisterAdapter.insert(session, persistenceName, json, valueType);
	}

	public static Long insertObject(final String persistenceName, final Object domainModel, final String... args)
			throws AdapterException {

		checkAdapter();

		return null;
	}

	public static Long update(final String persistenceName, final Long id, final String json, final String... args)
			throws AdapterException {

		checkAdapter();

		return null;
	}

	public static Long updateObject(final String persistenceName, final Long id, final Object domainModel,
			final String... args) throws AdapterException {

		checkAdapter();

		return null;
	}

	public String find(final String persistenceName, final Long id) throws AdapterException {

		checkAdapter();

		return null;
	}

	public <T> T findObject(final String persistenceName, final Long id, final Class<T> clz, final String... args)
			throws AdapterException {

		checkAdapter();

		return null;
	}

	public <T> List<T> findList(final String persistenceName, final String... args) throws AdapterException {

		checkAdapter();

		return null;
	}

	public void delete(final String persistenceName, final Long id) throws AdapterException {
		checkAdapter();

	}

	private static void checkAdapter() {
		if (persisterAdapter == null) {
			throw new RuntimeException("Persister adapter is not found, please check service provider configuration");
		}
	}
}
