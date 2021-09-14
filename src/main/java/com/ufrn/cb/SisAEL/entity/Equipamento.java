package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Equipamento extends Produto{

	@Column(unique = true, nullable = false)
	private long tombamento;

	public long getTombamento() {
		return tombamento;
	}

	public void setTombamento(Long tombamento) {
		this.tombamento = tombamento;
	}
	
}
