package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Entity;

@Entity
public class Pesquisador extends Cliente {
	
	private Long matricula;
	
	private String nome;
	
	private String email;

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
