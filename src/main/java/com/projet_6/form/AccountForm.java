
package com.projet_6.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountForm {

	@NotNull
	@Size(min = 2, max = 30)
	private String validationPseudo;

	@NotNull
	private String validationEmail;

	@NotNull
	@Size(min = 6, max = 30)
	private String validationPassWord;

	public String getValidationPseudo() {
		return validationPseudo;
	}

	public void setValidationPseudo(String validationPseudo) {
		this.validationPseudo = validationPseudo;
	}

	public String getValidationEmail() {
		return validationEmail;
	}

	public void setValidationEmail(String validationEmail) {
		this.validationEmail = validationEmail;
	}

	public String getValidationPassWord() {
		return validationPassWord;
	}

	public void setValidationPassWord(String validationPassWord) {
		this.validationPassWord = validationPassWord;
	}

}
