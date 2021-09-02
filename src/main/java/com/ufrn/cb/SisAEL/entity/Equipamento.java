package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Entity;

@Entity
public class Equipamento extends Produto{

	private Long tombamento;

	public Long getTombamento() {
		return tombamento;
	}

	public void setTombamento(Long tombamento) {
		this.tombamento = tombamento;
	}
	
	
}
