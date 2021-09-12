package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Equipamento extends Produto{

	@Column(unique = true)
	private Long tombamento;

	public Long getTombamento() {
		return tombamento;
	}

	public void setTombamento(Long tombamento) {
		this.tombamento = tombamento;
	}
	
	
}
