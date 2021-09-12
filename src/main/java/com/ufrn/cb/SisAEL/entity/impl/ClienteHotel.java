package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Entity;

@Entity
public class ClienteHotel extends Cliente{

	private String telefone;

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
