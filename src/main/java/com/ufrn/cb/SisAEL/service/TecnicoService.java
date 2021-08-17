package com.ufrn.cb.SisAEL.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Tecnico;
import com.ufrn.cb.SisAEL.exception.EntidadeNaoEncontradaException;

@Service
public class TecnicoService {
	
	@Autowired
	FachadaDados fachada;
	
	Tecnico obterPorNomeUsuario(String nomeUsuario) {
		
		Optional<Tecnico> opt = fachada.obterTecnicoPorNome(nomeUsuario);
		if(opt.isEmpty()) {
			throw new EntidadeNaoEncontradaException("Usuário não encontrado");
		}else {
			
			return opt.get();
		}
	}
	
	Tecnico cadastrar(Tecnico tecnico) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		tecnico.setSenha(encoder.encode(tecnico.getSenha()));
		return fachada.salvarTecnico(tecnico);
		
	}

}
