package com.github.jmodel.adapter.config;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Configuration
 * <p>
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
@XmlRootElement(name = "configuration")
@XmlAccessorType(XmlAccessType.FIELD)
public class Configuration {

	@XmlElement(name = "region")
	private List<Region> regionList;

	public List<Region> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<Region> regionList) {
		this.regionList = regionList;
	}

	public String getValue(String regionId, String itemId) {

		if (regionList != null) {
			Region region = regionList.stream().filter(it -> it.getId().equals(regionId)).findFirst().orElse(null);
			if (region != null && region.getItemList() != null) {
				Item item = region.getItemList().stream().filter(it -> it.getId().equals(itemId)).findFirst()
						.orElse(null);
				if (item != null) {
					return item.getValue();
				}
			}
		}
		return null;
	}

	public String getValue(String propertyName, String regionId, String... itemId) {

		if (regionList != null) {
			Region region = regionList.stream().filter(it -> it.getId().equals(regionId)).findFirst().orElse(null);
			if (region != null && region.getItemList() != null) {
				Item item = region.getItemList().stream().filter(it -> it.getId().equals(itemId)).findFirst()
						.orElse(null);
				if (item != null && item.getPropertyList() != null) {
					Property property = item.getPropertyList().stream().filter(it -> it.getName().equals(propertyName))
							.findFirst().orElse(null);
					if (property != null) {
						return property.getValue();
					}
				}
			}
		}
		return null;
	}

	public String getValue(String key) {
		return null;
	}
}
