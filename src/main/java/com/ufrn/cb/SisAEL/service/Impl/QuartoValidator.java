package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Quarto;

@Service
public class QuartoValidator extends ProdutoValidator{

	@Override
	public boolean validar(Produto produto) {
		Quarto quarto = (Quarto) produto;
		return quarto.getQtdCamas() > 0 && quarto.getQtdCamas()>0;
	}

}
