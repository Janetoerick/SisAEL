package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Produto;

import javassist.expr.Instanceof;

@Service
public class ProdutoValidatorImpl extends ProdutoValidator{

	@Override
	public boolean validar(Produto produto) {
		
		return true;
	}

}
