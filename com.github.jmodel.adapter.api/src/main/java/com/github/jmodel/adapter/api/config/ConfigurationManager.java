package com.github.jmodel.adapter.api.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * ConfigurationManager is used to manage configurations. In enterprise
 * environment, multiple configurations should be supported. For example,
 * baseline version defined a basic configuration, the customized project need
 * own configuration to extend or override basic configuration.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class ConfigurationManager {

	private static ConfigurationManager configurationManager;

	/**
	 * Configuration loader list can not be empty.
	 */
	private final Set<ConfigurationLoader> loaderSet = new HashSet<ConfigurationLoader>();

	/**
	 * Ordered configuration list managed by ConfigurationManager provides
	 * configuration override feature.
	 */
	private final List<Configuration> configurationList = new ArrayList<Configuration>();

	// construction methods

	/**
	 * private construction method
	 */
	private ConfigurationManager() {

	}

	/**
	 * This method is invisible from the outside. The outside can implement
	 * ConfigurationAware to use ConfigurationManager instance.
	 * 
	 * @return
	 */
	static ConfigurationManager getInstance() {
		if (configurationManager != null) {
			return configurationManager;
		}

		synchronized (ConfigurationManager.class) {
			configurationManager = new ConfigurationManager();
			return configurationManager;
		}
	}

	synchronized void addLoader(ConfigurationLoader loader) {
		if (!loaderSet.contains(loader)) {
			loaderSet.add(loader);
		}
	}

	// public methods

	public boolean hasLoader() {
		return !loaderSet.isEmpty();
	}

	public Set<ConfigurationLoader> getLoaders() {
		return loaderSet;
	}

	public synchronized void addConfiguration(Configuration configuration) {
		configurationList.add(configuration);
	}

	public <T> ConfiguratorAdapter<T> getAdapter() {
		return getAdapter(null);
	}

	@SuppressWarnings("unchecked")
	public <T> ConfiguratorAdapter<T> getAdapter(String text) {
		return (ConfiguratorAdapter<T>) ConfiguratorAdapterFactoryService.getInstance().getAdapter(text);
	}

	public Item getItem(String regionId, String... itemIds) {

		if (loaderSet.isEmpty()) {
			throw new MissingConfigException(ConfigurationLoader.printUsage());
		}

		Item item = null;
		ListIterator<Configuration> confIter = configurationList.listIterator(configurationList.size());
		while (confIter.hasPrevious()) {
			item = getItem(confIter.previous(), regionId, itemIds);
			if (item != null) {
				return item;
			}
		}

		throw new MissingConfigException(
				missingConfig("regionId:" + regionId + " itemIds:" + String.join(" and ", itemIds)));
	}

	public String getItemValue(String regionId, String... itemIds) {

		Item item = getItem(regionId, itemIds);
		if (item != null && item.getValue() != null) {
			return item.getValue();
		}

		throw new MissingConfigException(
				missingConfig("regionId:" + regionId + " itemIds:" + String.join(" and ", itemIds)));
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

		throw new MissingConfigException(missingConfig(
				"regionId:" + regionId + " itemIds:" + String.join(" and ", itemIds) + " property:" + propertyName));
	}

	// private methods

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

	private final String missingConfig(String msg) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t\n====================================\t\n");
		sb.append("Current valid configuration loaders:\t\n");
		int i = 1;
		for (ConfigurationLoader loader : loaderSet) {
			sb.append(i++).append(". ");
			sb.append(loader.getClass().getSimpleName()).append("\t\n");
		}
		sb.append("====================================\t\n");
		sb.append(msg);
		return sb.toString();
	}

}
