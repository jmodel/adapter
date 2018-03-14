package com.github.jmodel.adapter.api.config;

import javax.xml.bind.JAXBContext;

import com.github.jmodel.adapter.api.config.Configuration;
import com.github.jmodel.adapter.api.config.ConfiguratorAdapter;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public final class LocalFSConfiguratorAdapter extends ConfiguratorAdapter<String> {

	@Override
	public Configuration read(String fileName) {

		try {
			return (Configuration) JAXBContext.newInstance(Configuration.class).createUnmarshaller()
					.unmarshal(this.getClass().getClassLoader().getResourceAsStream(fileName));
		} catch (Exception e) {
			throw new RuntimeException("Failed to read local FS configuration", e);
		}
	}

}
