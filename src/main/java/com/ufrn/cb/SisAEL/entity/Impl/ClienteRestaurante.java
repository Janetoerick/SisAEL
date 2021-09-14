package com.ufrn.cb.SisAEL.entity.Impl;

import javax.persistence.Entity;

import com.ufrn.cb.SisAEL.entity.Cliente;

@Entity
public class ClienteRestaurante extends Cliente {
	
	private String email;
	
	private String telefone;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	

}
