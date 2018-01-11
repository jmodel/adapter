package com.github.jmodel.adapter.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import com.github.jmodel.adapter.Cacher;
import com.github.jmodel.api.control.AbstractAction;
import com.github.jmodel.api.control.ControlEnum;
import com.github.jmodel.api.control.F;
import com.github.jmodel.api.control.Feature;
import com.github.jmodel.api.control.S;
import com.github.jmodel.api.control.Service;
import com.github.jmodel.config.Configuration;
import com.github.jmodel.config.ConfigurationLoader;

/**
 * Util class
 * 
 * @author jianni@hotmail.com
 *
 */
public class Util {

	@SuppressWarnings("unchecked")
	public static <T> T findObject(ControlEnum control, String objectId) {

		try {

			Configuration conf = ConfigurationLoader.getInstance().getConfiguration();
			String regionId = null;
			switch (control) {
			case SERVICE:
				regionId = Service.getRegionId();
				break;
			case FEATURE:
				regionId = Feature.getRegionId();
				break;
			case ACTION:
				regionId = AbstractAction.getRegionId();
				break;
			default:
				throw new RuntimeException("");
			}

			String clzUrl = conf.getValue(regionId, objectId);

			T t = Cacher.get("objectCache", clzUrl);
			if (t == null) {

				Class<?> c = Class.forName(clzUrl);
				t = (T) c.newInstance();

				Properties properties = conf.getProperties(regionId, objectId);
				Method m = c.getMethod("setProperties", Properties.class);
				m.invoke(t, properties);

				Field[] fields = c.getDeclaredFields();
				for (Field field : fields) {
					F f = field.getDeclaredAnnotation(F.class);
					if (f != null && f.name() != null) {
						field.setAccessible(true);
						field.set(t, findObject(ControlEnum.FEATURE, f.name()));
					}

					S s = field.getDeclaredAnnotation(S.class);
					if (s != null && s.name() != null) {
						field.setAccessible(true);
						field.set(t, findObject(ControlEnum.SERVICE, s.name()));
					}
				}

				Cacher.put("objectCache", clzUrl, t);
			}
			return t;
		} catch (Exception e) {
			return null;
		}
	}
}
