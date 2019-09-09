package com.projet_6.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Site implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long siteId;
	@NotNull
	private String nameSite;
	@NotNull
	private String type;
	@NotNull
	private String orientation;
	@NotNull
	private String country;
	@NotNull
	private int sectorsNumber;
	@NotNull
	private int waysNumber;
	@NotNull
	private String cotation;

	public Site() {
		super();
	}

	public Site(Long siteId, String nameSite, String type, String orientation, String country, int sectorsNumber,
			int waysNumber, String cotation) {
		super();
		this.siteId = siteId;
		this.nameSite = nameSite;
		this.type = type;
		this.orientation = orientation;
		this.country = country;
		this.sectorsNumber = sectorsNumber;
		this.waysNumber = waysNumber;
		this.cotation = cotation;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getNameSite() {
		return nameSite;
	}

	public void setNameSite(String nameSite) {
		this.nameSite = nameSite;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getWaysNumber() {
		return waysNumber;
	}

	public void setWaysNumber(int waysNumber) {
		this.waysNumber = waysNumber;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	public int getSectorsNumber() {
		return sectorsNumber;
	}

	public void setSectorsnumber(int sectorsNumber) {
		this.sectorsNumber = sectorsNumber;
	}

}
