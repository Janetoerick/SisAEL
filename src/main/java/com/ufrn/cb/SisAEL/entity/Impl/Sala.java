package com.ufrn.cb.SisAEL.entity.Impl;

import java.util.List;

import javax.persistence.Entity;

import com.ufrn.cb.SisAEL.entity.Produto;

@Entity
public class Sala extends Produto{
	
	private String nome;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
	
	
	
	

}