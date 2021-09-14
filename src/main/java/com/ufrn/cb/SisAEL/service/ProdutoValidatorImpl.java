package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Quarto;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class ProdutoValidatorImpl extends ProdutoValidator{
	
	public boolean validar(Produto produto) {
		
		Quarto quarto = (Quarto) produto;
		
		if(quarto.getQtdCamasSolteiro()==0 && quarto.getQtdCamasCasal() ==0) {
			
			throw new DadosInvalidosException("O não possui camas!");
		}
		
		return true;
		
	}
}
