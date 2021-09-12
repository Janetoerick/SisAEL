package com.ufrn.cb.SisAEL.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;

@Service
public abstract class VerificadorProdutos {
	
	public abstract boolean verificar(List<Produto> produtos);

}
