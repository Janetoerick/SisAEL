package com.ufrn.cb.SisAEL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class VerificadorDadosClienteLaboratorio extends VerificadorDadosCliente {

	@Autowired
	FachadaDados fachada;
	
	@Override
	public boolean verificar(Cliente cliente) {
		
		Pesquisador pesquisador = (Pesquisador) cliente;
		
		if(pesquisador.getNome() == null || pesquisador.getNome().length() < 3) {
			throw new DadosInvalidosException("Nome de usuario muito curto");
		}
		
		for(Cliente p_teste: fachada.listarClientes()) {
			if(p_teste.getNomeUsuario() == pesquisador.getNomeUsuario()) {
				throw new DadosInvalidosException("Nome de Usuario indisponivel!");
			}
		}
		
		if(pesquisador.getNomeUsuario().length() < 5) {
			throw new DadosInvalidosException("Nome de Usuario muito pequeno!");
		}
		
		if(pesquisador.getSenha().length() < 5) {
			throw new DadosInvalidosException("Senha muito curta!!");
		}
		
		return true;
	}

}
