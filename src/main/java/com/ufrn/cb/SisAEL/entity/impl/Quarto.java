package com.ufrn.cb.SisAEL.entity.impl;

import javax.persistence.Entity;

import com.ufrn.cb.SisAEL.entity.Produto;

@Entity
public class Quarto extends Produto {
	
	private int qtdPessoas;
	
	private int qtdCamas;

	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public int getQtdCamas() {
		return qtdCamas;
	}

	public void setQtdCamas(int qtdCamas) {
		this.qtdCamas = qtdCamas;
	}
	
	
	
	

}
