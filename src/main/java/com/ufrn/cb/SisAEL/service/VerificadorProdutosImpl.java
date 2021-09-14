package com.ufrn.cb.SisAEL.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class VerificadorProdutosImpl extends VerificadorProdutos{
	
	public boolean verificar(List<Produto> produtos) {
		
		if(produtos == null || produtos.size()== 0) {
			
			throw new DadosIncompletosException("É nescessário um Quarto para a reserva");
		}else if(produtos !=null && produtos.size() >1) {
			
			throw new DadosInvalidosException("A reserva não pode ter mais que um quarto");
		}
		
		return true;
	}

}
