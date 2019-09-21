package com.projet_6.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Topo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long topoId;
	@NotNull
	private String topoName;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "member.username", nullable = false)
	@JsonIgnore
	private Member member;

	@NotNull
	private String topoDescription;

	// Upload files.
	@NotNull
	private MultipartFile[] fileDatas;

	public Topo() {
		super();
	}

	public Topo(Long topoId, String topoName, String topoDescription, MultipartFile[] fileDatas, Member member) {
		super();
		this.topoId = topoId;
		this.topoName = topoName;
		this.topoDescription = topoDescription;
		this.fileDatas = fileDatas;
		this.member = member;
	}

	public Long getTopoId() {
		return topoId;
	}

	public void setTopoId(Long topoId) {
		this.topoId = topoId;
	}

	public String getTopoName() {
		return topoName;
	}

	public void setTopoName(String topoName) {
		this.topoName = topoName;
	}

	public String getTopoDescription() {
		return topoDescription;
	}

	public void setDescription(String topoDescription) {
		this.topoDescription = topoDescription;
	}

	public MultipartFile[] getFileDatas() {
		return fileDatas;
	}

	public void setFileDatas(MultipartFile[] fileDatas) {
		this.fileDatas = fileDatas;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
