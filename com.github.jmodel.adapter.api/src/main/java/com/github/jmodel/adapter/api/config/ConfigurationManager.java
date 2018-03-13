package com.github.jmodel.adapter.api.config;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Configuration manager
 * <p>
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public final class ConfigurationManager {

	private static ConfigurationManager configurationManager;

	private final List<Configuration> configurationList = new ArrayList<Configuration>();

	//

	private ConfigurationManager() {

	}

	static ConfigurationManager getInstance() {
		if (configurationManager != null) {
			return configurationManager;
		}

		synchronized (ConfigurationManager.class) {
			configurationManager = new ConfigurationManager();
			return configurationManager;
		}
	}

	//

	public synchronized void addConfiguration(Configuration configuration) {
		configurationList.add(configuration);
	}

	//

	public <T> ConfiguratorAdapter<T> getAdapter() {
		return getAdapter(null);
	}

	@SuppressWarnings("unchecked")
	public <T> ConfiguratorAdapter<T> getAdapter(String configuratorAdapterId) {
		return (ConfiguratorAdapter<T>) ConfiguratorAdapterFactoryService.getInstance()
				.getAdapter(configuratorAdapterId);
	}

	//

	public Item getItem(String regionId, String... itemIds) {

		Item item = null;
		ListIterator<Configuration> confIter = configurationList.listIterator(configurationList.size());
		while (confIter.hasPrevious()) {
			item = getItem(confIter.previous(), regionId, itemIds);
			if (item != null) {
				return item;
			}
		}

		throw new MissingConfigException("regionId:" + regionId + " itemIds:" + String.join(" and ", itemIds));
	}

	public String getItemValue(String regionId, String... itemIds) {

		Item item = getItem(regionId, itemIds);
		if (item != null && item.getValue() != null) {
			return item.getValue();
		}

		throw new MissingConfigException("regionId:" + regionId + " itemIds:" + String.join(" and ", itemIds));
	}

	public String getPropertyValue(String propertyName, String regionId, String... itemIds) {

		Item item = getItem(regionId, itemIds);
		if (item != null) {
			Property property = item.getPropertyList().stream().filter(it -> it.getName().equals(propertyName))
					.findFirst().orElse(null);
			if (property != null && property.getValue() != null) {
				return property.getValue();
			}
		}

		throw new MissingConfigException(
				"regionId:" + regionId + " itemIds:" + String.join(" and ", itemIds) + " property:" + propertyName);
	}

	//

	private Item getItem(Configuration configuration, String regionId, String... itemIds) {
		Region region = configuration.getRegionList().stream().filter(it -> it.getId().equals(regionId)).findFirst()
				.orElse(null);
		if (region != null && region.getItemList() != null) {
			int itemsLen = itemIds.length;
			Item item = region.getItemList().stream().filter(it -> it.getId().equals(itemIds[0])).findFirst()
					.orElse(null);
			if (item != null) {
				if (itemsLen == 1) {
					return item;
				} else {
					return getSubItem(itemIds, item, itemIds[1], --itemsLen);
				}
			}
		}
		return null;
	}

	private Item getSubItem(String[] itemIds, Item item, String subItemId, int index) {

		List<Item> itemList = item.getItemList();
		if (itemList != null) {
			Item subItem = itemList.stream().filter(it -> it.getId().equals(subItemId)).findFirst().orElse(null);
			if (subItem != null) {
				if (index == 1) {
					return subItem;
				} else {
					return getSubItem(itemIds, subItem, itemIds[itemIds.length - index], --index);
				}
			}
		}
		return null;
	}

}
