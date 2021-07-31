package com.ufrn.cb.SisAEL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Pesquisador;

@Service
public class PesquisadorService {
	
	@Autowired
	FachadaDados fachada;
	
	public Pesquisador cadastrar(Pesquisador pesquisador) {
		
		Pesquisador p = fachada.salvarPesquisador(pesquisador);
		
		return p;
	}

}
