package com.projet_6.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank
	@NotNull
	private String email;
	@NotBlank
	@NotNull
	@Size(min = 4, max = 255)
	private String password;

	@Id
	@NotBlank
	@NotNull
	@Size(min = 4, max = 255)
	private String username;

	private boolean active = true;

	public Member() {
		super();
	}

	public Member(String email, String password, String username, Boolean active) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		this.active = active;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
