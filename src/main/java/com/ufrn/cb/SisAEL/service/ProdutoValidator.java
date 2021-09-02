package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;

@Service
public abstract class ProdutoValidator {

	public abstract boolean validar(Produto produto);

}
