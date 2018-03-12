package com.github.jmodel.adapter;

import java.util.Map;

import com.github.jmodel.adapter.api.Facade;
import com.github.jmodel.adapter.api.Term;
import com.github.jmodel.adapter.api.mapping.MapperAdapter;
import com.github.jmodel.adapter.api.mapping.MapperAdapterFactoryService;

/**
 * Public API for mapping.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class Mapper extends Facade {

	private final static MapperAdapterFactoryService _mapper_sp = MapperAdapterFactoryService.getInstance();

	private MapperAdapter mapperAdapter;

	private Mapper(String id, MapperAdapter mapperAdapter) {
		if (mapperAdapter == null) {
			throw new RuntimeException("Mapper adapter is not found.");
		}
		this.id = id;
		this.mapperAdapter = mapperAdapter;
	}

	//

	public static Mapper getMapper() {
		return getMapper(null);
	}

	public static Mapper getMapper(Term t) {
		String mapperAdapterId = getAdapterId(AdapterTerms.MAPPER, t);
		Mapper mapper = fm.getFacade(mapperAdapterId);
		if (mapper != null) {
			return mapper;
		}

		synchronized (fm) {
			if (mapper == null) {
				mapper = new Mapper(mapperAdapterId, _mapper_sp.getAdapter(mapperAdapterId));
				fm.addFacade(mapper);
			}
			return mapper;
		}
	}

	//

	public <T> T convert(Object sourceObj, String mappingURI, Map<String, Object> argsMap, Class<T> valueType)
			throws AdapterException {
		return mapperAdapter.convert(sourceObj, mappingURI, argsMap, valueType);
	}

	public <T> T convert(Object sourceObj, String mappingURI, Class<T> valueType) throws AdapterException {
		return mapperAdapter.convert(sourceObj, mappingURI, valueType);
	}

}
