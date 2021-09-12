package com.ufrn.cb.SisAEL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Produto;

@Service
public abstract class VerificadorProdutos {
	
	@Autowired
	FachadaDados fachada;
	
	public abstract boolean verificar(List<Produto> produtos);

}
