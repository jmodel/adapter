package com.github.jmodel.adapter;

import java.util.Map;

import com.github.jmodel.adapter.api.Facade;
import com.github.jmodel.adapter.api.mapping.MapperAdapter;
import com.github.jmodel.adapter.api.mapping.MapperAdapterFactoryService;
import com.github.jmodel.adapter.spi.Term;

/**
 * Simple mapping facade.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class Mapper extends Facade<MapperAdapter> {

	/**
	 * Mapper adapter factory service
	 */
	private final static MapperAdapterFactoryService _mapper_sp = MapperAdapterFactoryService.getInstance();

	private Mapper(MapperAdapter mapperAdapter) {
		this.adapter = mapperAdapter;
	}

	//

	public static Mapper getMapper() {
		return getMapper(null);
	}

	public static Mapper getMapper(Term adapterTerm) {
		MapperAdapter mapperAdapter = _mapper_sp
				.getAdapter(getTermText(tfs.getTerm(AdapterTerms.MAPPER_ADAPTER), adapterTerm));
		Mapper mapper = fm.getFacade(mapperAdapter);
		if (mapper != null) {
			return mapper;
		}

		synchronized (fm) {
			if (mapper == null) {
				mapper = new Mapper(mapperAdapter);
				fm.addFacade(mapper);
			}
			return mapper;
		}
	}

	//

	public <T> T convert(Object sourceObj, String mappingURI, Map<String, Object> argsMap, Class<T> valueType)
			throws AdapterException {
		return adapter.convert(sourceObj, mappingURI, argsMap, valueType);
	}

	public <T> T convert(Object sourceObj, String mappingURI, Class<T> valueType) throws AdapterException {
		return adapter.convert(sourceObj, mappingURI, valueType);
	}

}
