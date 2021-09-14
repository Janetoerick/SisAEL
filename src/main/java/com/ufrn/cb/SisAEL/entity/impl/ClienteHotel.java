package com.ufrn.cb.SisAEL.entity.impl;

import javax.persistence.Entity;

import com.ufrn.cb.SisAEL.entity.Cliente;

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
