package com.github.jmodel.adapter;

import java.util.List;

import com.github.jmodel.adapter.api.Facade;
import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.adapter.api.persistence.PersisterAdapter;
import com.github.jmodel.adapter.api.persistence.PersisterAdapterFactoryService;
import com.github.jmodel.adapter.spi.Term;

/**
 * Simple persistence facade.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class Persister extends Facade<PersisterAdapter> {

	/**
	 * Persister adapter factory service
	 */
	private final static PersisterAdapterFactoryService _persister_sp = PersisterAdapterFactoryService.getInstance();

	private Persister(PersisterAdapter persisterAdapter) {
		this.adapter = persisterAdapter;
	}

	//

	public static Persister getPersister() {
		return getPersister(null);
	}

	public static Persister getPersister(Term adapterTerm) {
		PersisterAdapter persisterAdapter = _persister_sp
				.getAdapter(getTermText(tfs.getTerm(AdapterTerms.PERSISTER_ADAPTER), adapterTerm));
		Persister persister = fm.getFacade(persisterAdapter);
		if (persister != null) {
			return persister;
		}

		synchronized (fm) {
			if (persister == null) {
				persister = new Persister(persisterAdapter);
				fm.addFacade(persister);
			}
			return persister;
		}
	}

	//

	public <S, T> Long insert(S session, Action<?, ?, ?> action, String json, Class<T> valueType)
			throws AdapterException {
		return adapter.insert(session, action, json, valueType);
	}

	public <S> Long insertObject(S session, Action<?, ?, ?> action, Object obj) throws AdapterException {
		return adapter.insertObject(session, action, obj);
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
