package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Sala extends Produto{
	
	@Column(nullable = false)
	private String nome;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
	
	
	
	

}
