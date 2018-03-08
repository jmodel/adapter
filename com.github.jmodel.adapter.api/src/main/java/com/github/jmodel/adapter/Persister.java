package com.github.jmodel.adapter;

import java.util.List;

import com.github.jmodel.adapter.api.Facade;
import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.adapter.api.persistence.PersisterAdapter;
import com.github.jmodel.adapter.api.persistence.PersisterAdapterFactoryService;

/**
 * Public API for persistence.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class Persister extends Facade {

	private final static PersisterAdapterFactoryService _persister_sp = PersisterAdapterFactoryService.getInstance();

	private PersisterAdapter persisterAdapter;

	private Persister(String id, PersisterAdapter persisterAdapter) {
		if (persisterAdapter == null) {
			throw new RuntimeException("Persister adapter is not found.");
		}
		this.id = id;
		this.persisterAdapter = persisterAdapter;
	}

	//

	public static Persister getPersister() {
		return getPersister(null);
	}

	public static Persister getPersister(String name) {
		String persisterAdapterId = getAdapterId(AdapterTerms.PERSISTER, name);
		Persister persister = facadeManager.getFacade(persisterAdapterId);
		if (persister != null) {
			return persister;
		}

		synchronized (facadeManager) {
			if (persister == null) {
				persister = new Persister(persisterAdapterId, _persister_sp.getAdapter(persisterAdapterId));
				facadeManager.addFacade(persister);
			}
			return persister;
		}
	}

	public <S, T> Long insert(S session, Action<?, ?, ?> action, String json, Class<T> valueType)
			throws AdapterException {
		return persisterAdapter.insert(session, action, json, valueType);
	}

	public <S> Long insertObject(S session, Action<?, ?, ?> action, Object obj) throws AdapterException {
		return persisterAdapter.insertObject(session, action, obj);
	}

	public Long update(final String persistenceName, final Long id, final String json, final String... args)
			throws AdapterException {
		return null;
	}

	public Long updateObject(final String persistenceName, final Long id, final Object domainModel,
			final String... args) throws AdapterException {
		return null;
	}

	public String find(final String persistenceName, final Long id) throws AdapterException {
		return null;
	}

	public <T> T findObject(final String persistenceName, final Long id, final Class<T> clz, final String... args)
			throws AdapterException {
		return null;
	}

	public <T> List<T> findList(final String persistenceName, final String... args) throws AdapterException {
		return null;
	}

	public void delete(final String persistenceName, final Long id) throws AdapterException {

	}

}
