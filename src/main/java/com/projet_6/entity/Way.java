package com.projet_6.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Way implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wayId;
	@NotNull
	private String nameWay;

	private String typeWay;
	private String cotation;
	private int height;
	@NotNull
	private String descriptionWay;

	public Way() {
		super();
	}

	public Way(Long wayId, String nameWay, String typeWay, String cotation, int height, String descriptionWay) {
		super();
		this.wayId = wayId;
		this.nameWay = nameWay;
		this.typeWay = typeWay;
		this.cotation = cotation;
		this.height = height;
		this.descriptionWay = descriptionWay;
	}

	public Long getWayId() {
		return wayId;
	}

	public void setWayId(Long wayId) {
		this.wayId = wayId;
	}

	public String getNameWay() {
		return nameWay;
	}

	public void setNameWay(String nameWay) {
		this.nameWay = nameWay;
	}

	public String getDescriptionWay() {
		return descriptionWay;
	}

	public void setDescriptionWay(String descriptionWay) {
		this.descriptionWay = descriptionWay;
	}

	public String getTypeWay() {
		return typeWay;
	}

	public void setTypeWay(String typeWay) {
		this.typeWay = typeWay;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
