package com.ufrn.cb.SisAEL.entity.Impl;

import javax.persistence.Entity;

import com.ufrn.cb.SisAEL.entity.Produto;

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
