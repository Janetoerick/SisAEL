package com.ufrn.cb.SisAEL.service.Impl;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Impl.Mesa;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.service.ProdutoValidator;

@Service
public class MesaValidator extends ProdutoValidator{

	public boolean validar(Produto produto) {
		
		if(produto instanceof Mesa) {
			Mesa m = (Mesa) produto;
			if(m.getQntLugares() <= 0) {
				throw new DadosInvalidosException("Quantidade de lugares invalido!");
			}
		} 
		
		return true;
	}
}
