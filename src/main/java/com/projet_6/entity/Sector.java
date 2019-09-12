package com.projet_6.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
	private String nameSector;
	@NotNull
	private String descriptionSector;

	public Sector() {
		super();
	}

	public Sector(Long sectorId, String nameSector, String descriptionSector) {
		super();
		this.sectorId = sectorId;
		this.nameSector = nameSector;
		this.descriptionSector = descriptionSector;
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

}
