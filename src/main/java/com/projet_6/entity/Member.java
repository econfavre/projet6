package com.projet_6.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	@NotNull
	private String email;
	@NotNull
	@Size(min = 4, max = 30)
	private String passWord;
	@NotNull
	@Size(min = 4, max = 30)
	private String pseudo;
	// private Blob imageMember;

	public Member() {
		super();
	}

	public Member(Long memberId, String email, String passWord, String pseudo, Blob imageMember) {
		super();
		this.email = email;
		this.passWord = passWord;
		this.pseudo = pseudo;
		// this.setImageMember(imageMember);
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPseudo() {
		return pseudo;
	}

	// public Blob getImageMember() {
	// return imageMember;
	// }

	// public void setImageMember(Blob imageMember) {
	// this.imageMember = imageMember;
	// }
}
