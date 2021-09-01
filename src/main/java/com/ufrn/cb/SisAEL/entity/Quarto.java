package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Entity;

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
