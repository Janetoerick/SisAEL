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
	
	public Admin obterPorNomeUsuario(String nomeUsuario) {
		
		Optional<Admin> opt = fachada.obterAdmin(nomeUsuario);
		if(opt.isEmpty()) {
			throw new EntidadeNaoEncontradaException("Usuário não encontrado");
		}else {
			
			return opt.get();
		}
	}
	
	public  Admin cadastrar(Admin admin) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		admin.setSenha(encoder.encode(admin.getSenha()));
		return fachada.salvarAdmin(admin);
		
	}

}
