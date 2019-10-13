package com.projet_6.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

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

	@ManyToOne
	@JoinColumn(name = "username", nullable = false)
	private Member member;

	@NotNull
	private String topoDescription;

//	// Upload files.
//	@NotNull
//	private MultipartFile[] fileDatas;

	private String topoFile;

	public Topo() {
		super();
	}

	public Topo(Long topoId, String topoName, String topoDescription, String topoFile, Member member) {
		super();
		this.topoId = topoId;
		this.topoName = topoName;
		this.topoDescription = topoDescription;
		// this.fileDatas = fileDatas;
		this.topoFile = topoFile;
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getTopoDescription() {
		return topoDescription;
	}

//	public MultipartFile[] getFileDatas() {
//		return fileDatas;
//	}
//
//	public void setFileDatas(MultipartFile[] fileDatas) {
//		this.fileDatas = fileDatas;
//	}

	public void setTopoDescription(String topoDescription) {
		this.topoDescription = topoDescription;
	}

	public String getTopoFile() {
		return topoFile;
	}

	public void setTopoFile(String topoFile) {
		this.topoFile = topoFile;
	}

	@Override
	public String toString() {
		return "Topo [topoId=" + topoId + ", topoName=" + topoName + ", member=" + member + ", topoDescription="
				+ topoDescription + ", topoFile=" + topoFile + "]";
	}
}
