package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Quarto extends Produto{
		
	@Column(nullable = false, unique = true)
	private int numero;
	private int qtdCamasSolteiro;
	private int qtdCamasCasal;
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getQtdCamasSolteiro() {
		return qtdCamasSolteiro;
	}
	public void setQtdCamasSolteiro(int qtdCamasSolteiro) {
		this.qtdCamasSolteiro = qtdCamasSolteiro;
	}
	public int getQtdCamasCasal() {
		return qtdCamasCasal;
	}
	public void setQtdCamasCasal(int qtdCamasCasal) {
		this.qtdCamasCasal = qtdCamasCasal;
	}

	
	
	
}
