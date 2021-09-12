package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Pesquisador extends Cliente {
	
	@Column(unique = true, nullable = false)
	private Long matricula;
	
	private String nome;
	
	@Column(unique = true)
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
