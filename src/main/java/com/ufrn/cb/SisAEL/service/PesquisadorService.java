package com.ufrn.cb.SisAEL.service;

import java.util.List;

import com.ufrn.cb.SisAEL.entity.Pesquisador;

public interface PesquisadorService {
	List<Pesquisador> listarPorNome(String nome);
	List<Pesquisador> listar();
	Pesquisador autenticarViaGoogle();
	void sair();
	
}
