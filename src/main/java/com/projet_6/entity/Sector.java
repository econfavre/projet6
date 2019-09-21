package com.projet_6.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sector implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sectorId;
	@NotNull
	@NotBlank
	private String nameSector;

	@NotNull
	@NotBlank
	private String descriptionSector;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "site.siteId", nullable = false)
	@JsonIgnore
	private Site site;

	public Sector() {
		super();
	}

	public Sector(Long sectorId, String nameSector, String descriptionSector, Site site) {
		super();
		this.sectorId = sectorId;
		this.nameSector = nameSector;
		this.descriptionSector = descriptionSector;
		this.site = site;
	}

	public Long getSectorId() {
		return sectorId;
	}

	public void setSectorId(Long sectorId) {
		this.sectorId = sectorId;
	}

	public String getNameSector() {
		return nameSector;
	}

	public void setNameSector(String nameSector) {
		this.nameSector = nameSector;
	}

	public String getDescriptionSector() {
		return descriptionSector;
	}

	public void setDescriptionSector(String descriptionSector) {
		this.descriptionSector = descriptionSector;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
