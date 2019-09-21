package com.projet_6.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long reservationId;

	@NotBlank
	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate reservationBeginDate;

	@NotBlank
	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate reservationEndDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "member.username", nullable = false)
	@JsonIgnore
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "topo.topoId", nullable = false)
	@JsonIgnore
	private Topo topo;

	public Reservation() {
		super();
	}

	public Reservation(Long reservationId, LocalDate reservationBeginDate, LocalDate reservationEndDate, Member member,
			Topo topo) {
		super();
		this.reservationId = reservationId;
		this.reservationBeginDate = reservationBeginDate;
		this.reservationEndDate = reservationEndDate;
		this.member = member;
		this.topo = topo;

	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public LocalDate getReservationBeginDate() {
		return reservationBeginDate;
	}

	public void setReservationBeginDate(LocalDate reservationBeginDate) {
		this.reservationBeginDate = reservationBeginDate;
	}

	public LocalDate getReservationEndDate() {
		return reservationEndDate;
	}

	public void setReservationEndDate(LocalDate reservationEndDate) {
		this.reservationEndDate = reservationEndDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

}
