package com.github.jmodel.adapter.api;

/**
 * Config is a particular adapter. The implementation of config is specified by
 * a file named config.properties. If this file does not exist, use default
 * implementation {@code ConfigImpl}.
 * <p>
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public interface Config {

	public String getValue(String key);
}
