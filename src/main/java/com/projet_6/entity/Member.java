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
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long memberId;

	@NotBlank
	@NotNull
	@Size(min = 4, max = 50)
	private String username;

	@NotBlank
	@NotNull
	private String email;

	@NotBlank
	@NotNull
	@Size(min = 4, max = 30)
	private String password;

	private boolean active = true;

//	@OneToMany(mappedBy = "member")
//	private List<Site> sites;

	public Member() {
		super();
	}

	public Member(String username, String email, String password, Boolean active) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.active = active;

	}

//	public Long getMemberId() {
//		return memberId;
//	}
//
//	public void setMemberId(Long memberId) {
//		this.memberId = memberId;
//	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
