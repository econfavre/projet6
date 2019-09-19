package com.projet_6.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SiteForm {

	@NotNull
	@NotBlank
	private String validationNameSite;
	@NotNull
	@NotBlank
	private String validationOrientation;
	@NotNull
	@NotBlank
	private String validationCountry;
	@NotNull
	@NotBlank
	private String validationDescriptionSite;

	public String getValidationNameSite() {
		return validationNameSite;
	}

	public void setValidationNameSite(String validationNameSite) {
		this.validationNameSite = validationNameSite;
	}

	public String getValidationOrientation() {
		return validationOrientation;
	}

	public void setValidationOrientation(String validationOrientation) {
		this.validationOrientation = validationOrientation;
	}

	public String getValidationCountry() {
		return validationCountry;
	}

	public void setValidationCountry(String validationCountry) {
		this.validationCountry = validationCountry;
	}

	public String getValidationDescriptionSite() {
		return validationDescriptionSite;
	}

	public void setValidationDescriptionSite(String validationDescriptionSite) {
		this.validationDescriptionSite = validationDescriptionSite;
	}

}
