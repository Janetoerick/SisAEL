package com.ufrn.cb.SisAEL.entity.Impl;

import javax.persistence.Entity;

import com.ufrn.cb.SisAEL.entity.Produto;

@Entity
public class Mesa extends Produto{

	private int qntLugares;

	public int getQntLugares() {
		return qntLugares;
	}

	public void setQntLugares(int qntLugares) {
		this.qntLugares = qntLugares;
	}
	
	
	
}
