package com.github.jmodel.adapter.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.jmodel.adapter.Cacher;
import com.github.jmodel.adapter.api.AdapterFactoryService;

/**
 * Util class
 * 
 * @author jianni@hotmail.com
 *
 */
public class Util {

	/**
	 * JDK Logger
	 */
	private final static Logger logger = Logger.getLogger(AdapterFactoryService.class.getName());

	@SuppressWarnings("unchecked")
	public static <T> T find(String clzUrl) {

		try {
			T t = Cacher.get("objectCache", clzUrl);
			if (t == null) {
				t = (T) Class.forName(clzUrl).newInstance();
				Cacher.put("objectCache", clzUrl, t);
			}
			return t;
		} catch (Exception e) {
			logger.log(Level.WARNING, () -> "The class is not found : " + clzUrl);
			return null;
		}
	}
}
