package com.github.jmodel.adapter.api.config;

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

}
