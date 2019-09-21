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
public class Site implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long siteId;
	@NotNull
	@NotBlank
	private String nameSite;
	@NotNull
	@NotBlank
	private String orientation;
	@NotNull
	@NotBlank
	private String country;
	@NotNull
	@NotBlank
	private String descriptionSite;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "member.username", nullable = false)
	@JsonIgnore
	private Member member;

	public Site() {
		super();
	}

	public Site(Long siteId, String nameSite, String orientation, String country, String descriptionSite,
			Member member) {
		super();
		this.siteId = siteId;
		this.nameSite = nameSite;
		this.orientation = orientation;
		this.country = country;
		this.descriptionSite = descriptionSite;
		this.member = member;
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

	public void setDescriptionSite(String descriptionSite) {
		this.descriptionSite = descriptionSite;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
