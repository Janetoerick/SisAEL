package com.ufrn.cb.SisAEL.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Laboratorio extends Produto{
	
	private String nome;
	
	@OneToMany
	private List<Sala> salas;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}
	

	
}
