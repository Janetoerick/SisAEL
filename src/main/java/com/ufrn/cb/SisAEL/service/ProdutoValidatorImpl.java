package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Mesa;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class ProdutoValidatorImpl extends ProdutoValidator{
	
	public boolean validar(Produto produto) {
		
		Mesa mesa = (Mesa) produto;
		if(mesa.getQtdLugares() == 0) {
			throw new DadosInvalidosException("A quantidade de "
					+ "lugares não pode ser 0");
		}
		
	
		
		return true;
		
	}
}
