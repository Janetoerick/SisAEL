package com.ufrn.cb.SisAEL.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.exception.EntidadeNaoEncontradaException;

@Service
public class PesquisadorService {
	
	@Autowired
	FachadaDados fachada;
	
	public Pesquisador cadastrar(Pesquisador pesquisador) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		pesquisador.setSenha(encoder.encode(pesquisador.getSenha()));
		Pesquisador p = fachada.salvarPesquisador(pesquisador);
		
		return p;
	}
	
	public Pesquisador obterPesquisadorPorNomeUsuario(String nomeUsuario) {
		
		Optional<Pesquisador> dado =  fachada.obterPesquisadorPorNome(nomeUsuario);
		if(dado.isPresent()) {
			return dado.get();
		}else {
			
			throw new EntidadeNaoEncontradaException("Este usuário não foi encontrado");
		}
	}

}
