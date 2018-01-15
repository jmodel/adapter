package com.github.jmodel.adapter.utils;

import java.lang.reflect.Field;
import java.util.List;

import com.github.jmodel.adapter.AdapterException;
import com.github.jmodel.adapter.Cacher;
import com.github.jmodel.api.control.AbstractAction;
import com.github.jmodel.api.control.ControlEnum;
import com.github.jmodel.api.control.F;
import com.github.jmodel.api.control.Feature;
import com.github.jmodel.api.control.Path;
import com.github.jmodel.api.control.S;
import com.github.jmodel.api.control.Service;
import com.github.jmodel.config.Configuration;
import com.github.jmodel.config.ConfigurationLoader;
import com.github.jmodel.config.Item;
import com.github.jmodel.config.Property;

/**
 * Adapter Util class.
 * 
 * @author jianni@hotmail.com
 *
 */
public class AdapterUtil {

	@SuppressWarnings("unchecked")
	public static <T> T findObject(ControlEnum control, String objectId) throws AdapterException {

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
			default:
				// ACTION
				regionId = AbstractAction.getRegionId();
			}

			String clzUrl = conf.getValue(regionId, objectId);
			T t = Cacher.get("objectCache", clzUrl);
			if (t == null) {

				Class<?> c = Class.forName(clzUrl);
				t = (T) c.newInstance();

				Item item = conf.getItem(regionId, objectId);

				// set config properties
				switch (control) {
				case SERVICE:
					buildService(c, (Service<?, ?>) t, item);
					break;
				case FEATURE:
					buildFeature(c, (Feature<?, ?>) t, item);
					break;
				default:
					break;
				}

				Cacher.put("objectCache", clzUrl, t);
			}

			return t;
		} catch (Exception e) {
			throw new AdapterException("Failed to find object", e);
		}
	}

	private static void buildService(Class<?> c, Service<?, ?> service, Item item) throws AdapterException {

		List<Property> propertyList = item.getPropertyList();
		if (propertyList != null) {
			for (Property property : propertyList) {
				service.getProperties().put(property.getName(), property.getValue());
			}
		}

		List<Item> subItemList = item.getItemList();
		if (subItemList != null && subItemList.size() > 0) {
			for (Item subItem : subItemList) {
				Path path = new Path();
				buildPath(path, subItem);
				service.getPathMap().put(subItem.getId(), path);
			}
		}

		buildAnnotationField(c, service);
	}

	private static void buildPath(Path path, Item item) throws AdapterException {

		List<Property> propertyList = item.getPropertyList();
		if (propertyList != null) {
			for (Property property : propertyList) {
				path.getProperties().put(property.getName(), property.getValue());
			}
		}
	}

	private static void buildFeature(Class<?> c, Feature<?, ?> feature, Item item) throws AdapterException {

		List<Property> propertyList = item.getPropertyList();
		if (propertyList != null) {
			for (Property property : propertyList) {
				feature.getProperties().put(property.getName(), property.getValue());
			}
		}
		
		buildAnnotationField(c, feature);
	}

	private static void buildAnnotationField(Class<?> c, Object o) throws AdapterException {

		try {

			Field[] fields = c.getDeclaredFields();
			for (Field field : fields) {

				// handle feature annotation
				F f = field.getDeclaredAnnotation(F.class);
				if (f != null && f.name() != null) {
					field.setAccessible(true);
					field.set(o, findObject(ControlEnum.FEATURE, f.name()));
				}

				// handle service annotation
				S s = field.getDeclaredAnnotation(S.class);
				if (s != null && s.name() != null) {
					field.setAccessible(true);
					field.set(o, findObject(ControlEnum.SERVICE, s.name()));
				}
			}
		} catch (Exception e) {
			throw new AdapterException("Failed to build annotation fields", e);
		}
	}
}
