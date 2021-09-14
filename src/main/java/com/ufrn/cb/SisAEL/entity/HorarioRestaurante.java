package com.ufrn.cb.SisAEL.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	public boolean equals(Object outro) {
		
		return data.equals(((HorarioRestaurante)outro).getData()) 
				&&   hora.equals(((HorarioRestaurante)outro).getHora());
	}

	@Override
	public String toString() {
		return("Data: " + data.toString() + " " + "Hora: " + hora);
	}
	
}
