package com.projet_6.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long commentId;

	@NotBlank
	@NotNull
	@Size(max = 255)
	private String comment;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "member.username", nullable = false)
	@JsonIgnore
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "site.siteId", nullable = false)
	@JsonIgnore
	private Site site;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "topo.topoId", nullable = false)
	@JsonIgnore
	private Topo topo;

	public Comment() {
		super();
	}

	public Comment(Long commentId, String comment, Member member, Site site, Topo topo) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.member = member;
		this.site = site;
		this.topo = topo;

	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

}
