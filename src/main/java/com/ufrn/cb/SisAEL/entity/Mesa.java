package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Entity;

@Entity
public class Mesa extends Produto{
		
	private int qtdLugares;
	
	public int getQtdLugares() {
		return qtdLugares;
	}
	public void setQtdLugares(int numero) {
		this.qtdLugares = numero;
	}

	
}
