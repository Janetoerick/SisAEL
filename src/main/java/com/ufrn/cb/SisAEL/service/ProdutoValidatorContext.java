package com.ufrn.cb.SisAEL.service;

import com.ufrn.cb.SisAEL.entity.Produto;

public class ProdutoValidatorContext {
	
	private ValidatorStrategy strategy;
	
	public boolean validar(Produto produto) {
		
		return strategy.validar(produto);
	}
	
	public void setStrategy(ValidatorStrategy strategy) {
		
		this.strategy = strategy;
	}
	
	

}
