package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Entity;

@Entity
public class Pesquisador extends Cliente{

	private long matricula;
	private String email;
	
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

}
