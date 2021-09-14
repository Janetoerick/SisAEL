package com.ufrn.cb.SisAEL.entity.Impl;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

import com.ufrn.cb.SisAEL.entity.Horario;

@Entity
public class HorarioRestaurante extends Horario{
	
	private LocalDate data;
	
	private LocalTime hora;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	
	
}
