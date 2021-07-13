package com.ufrn.cb.SisAEL.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="horarioHasReserva")
public class HorariosDaReserva {
	
	@Id
	@Column(name="idReserva")
	private Long idReserva;
	
	@Column(name="idHorario")
	private int idHorario;

	public HorariosDaReserva(Long idReserva, int idHorario) {
		super();
		this.idReserva = idReserva;
		this.idHorario = idHorario;
	}

	public HorariosDaReserva() {
		super();
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	
	
	
	
}
