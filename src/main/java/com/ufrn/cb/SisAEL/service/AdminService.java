package com.ufrn.cb.SisAEL.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Admin;
import com.ufrn.cb.SisAEL.exception.EntidadeNaoEncontradaException;

@Service
public class AdminService {
	
	@Autowired
	FachadaDados fachada;
	
	Admin obterPorNomeUsuario(String nomeUsuario) {
		
		Optional<Admin> opt = fachada.obterAdmin(nomeUsuario);
		if(opt.isEmpty()) {
			throw new EntidadeNaoEncontradaException("Usuário não encontrado");
		}else {
			
			return opt.get();
		}
	}
	
	Admin cadastrar(Admin tecnico) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		tecnico.setSenha(encoder.encode(tecnico.getSenha()));
		return fachada.salvarAdmin(tecnico);
		
	}

}
