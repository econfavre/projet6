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
	private String orientation;
	@NotNull
	private String country;
	@NotNull
	private String descriptionSite;

	public Site() {
		super();
	}

	public Site(Long siteId, String nameSite, String orientation, String country, String descriptionSite) {
		super();
		this.siteId = siteId;
		this.nameSite = nameSite;
		this.orientation = orientation;
		this.country = country;
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

	public String getDescriptionSite() {
		return descriptionSite;
	}

	public void setDescriptionSector(String descriptionSite) {
		this.descriptionSite = descriptionSite;
	}

}
