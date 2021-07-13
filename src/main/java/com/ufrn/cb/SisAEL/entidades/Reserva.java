package com.ufrn.cb.SisAEL.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {
	
	@Id
	@Column(name="idReserva")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="idEquip")
	private Long idEquip;
	
	@Column(name="matPesquisador")
	private Long matPesquisador;
	
	@Column(name="data")
	private String data;
	
	public Reserva() {
		super();
	}

	public Reserva(Long idReserva, Long idEquip, Long matPesquisador, String data) {
		super();
		this.id = idReserva;
		this.idEquip = idEquip;
		this.matPesquisador = matPesquisador;
		this.data = data;
	}

	public Long getIdReserva() {
		return id;
	}

	public void setIdReserva(Long idReserva) {
		this.id = idReserva;
	}

	public Long getIdEquip() {
		return idEquip;
	}

	public void setIdEquip(Long idEquip) {
		this.idEquip = idEquip;
	}

	public Long getMatPesquisador() {
		return matPesquisador;
	}

	public void setMatPesquisador(Long matPesquisador) {
		this.matPesquisador = matPesquisador;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	
	
	
	
}
