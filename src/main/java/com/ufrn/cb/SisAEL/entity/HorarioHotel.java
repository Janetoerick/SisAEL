package com.ufrn.cb.SisAEL.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

import org.springframework.transaction.annotation.Transactional;

@Entity
public class HorarioHotel extends Horario{
	
	private LocalDate dataInicial;
	
	private LocalDate dataFinal;
	
	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	@Override
	public String toString() {
		return("Data inicial: " + dataInicial.toString() + " " + "Data final: " + dataFinal);
	}
	
}
