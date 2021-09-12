package com.ufrn.cb.SisAEL.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

@Entity
public class HorarioLaboratorio extends Horario{
	
	private LocalDate data;
	
	private LocalTime horaInicial;
	
	private LocalTime horaFinal;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(LocalTime horaInicial) {
		this.horaInicial = horaInicial;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
	}
	
	public boolean equals(Object outro) {
		HorarioLaboratorio hLab = (HorarioLaboratorio) outro;
		return this.data.equals(hLab.getData())
			   && this.horaInicial.equals(hLab.getHoraInicial())
			   && this.horaFinal.equals(hLab.getHoraFinal());
	}
	
	@Override
	public String toString() {
		return this.data.toString() + "  " + " inicio: " 
					+ this.getHoraInicial().toString() + " fim: "
					+ this.getHoraFinal().toString();
	}
	
}
