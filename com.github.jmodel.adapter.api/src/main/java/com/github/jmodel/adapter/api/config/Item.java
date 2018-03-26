package com.github.jmodel.adapter.api.config;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Item
 * 
 * @author jianni@hotmail.com
 *
 */
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

	@XmlAttribute
	private String id;

	@XmlAttribute
	private String value;

	@XmlAttribute
	private String monitor;

	@XmlElement(name = "item")
	private List<Item> itemList;

	@XmlElement(name = "property")
	private List<Property> propertyList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<Property> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<Property> propertyList) {
		this.propertyList = propertyList;
	}

}
