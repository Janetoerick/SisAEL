package com.ufrn.cb.SisAEL.service.Impl;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.impl.Quarto;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.service.ProdutoValidator;

@Service
public class QuartoValidator extends ProdutoValidator{

	@Override
	public boolean validar(Produto produto) {
		if(produto instanceof Quarto) {
			Quarto q = (Quarto) produto;
			if((q.getQtdPessoas() > 0 && q.getQtdPessoas() < 10) && (q.getQtdCamas() > 0 && q.getQtdCamas() < 6)) {
				return true;
			} else {
				throw new DadosInvalidosException("Dados de quantidade invalidos!!");
			}
		}
		throw new DadosInvalidosException("Objeto passado nao eh um Quarto!!");
	}

}
