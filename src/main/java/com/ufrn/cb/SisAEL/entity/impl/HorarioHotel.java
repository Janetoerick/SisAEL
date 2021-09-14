package com.ufrn.cb.SisAEL.entity.impl;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.ufrn.cb.SisAEL.entity.Horario;

@Entity
public class HorarioHotel extends Horario{
	
	LocalDate dataInicial;
	
	LocalDate dataFinal;

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
	
	

}
