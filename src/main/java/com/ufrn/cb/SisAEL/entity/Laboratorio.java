package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Entity;

@Entity
public class Laboratorio extends Produto {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
