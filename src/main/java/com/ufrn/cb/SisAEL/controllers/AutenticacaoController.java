package com.ufrn.cb.SisAEL.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.entity.Tecnico;
import com.ufrn.cb.SisAEL.entity.Usuario;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {
	
	@Autowired
	FachadaService fachada;
	
	@GetMapping("login")
	public ResponseEntity<Usuario> login() {
		
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {
			UserDetails userD = (UserDetails) principal;
			Object[] auths = userD.getAuthorities().toArray();
			String tipoUsuario = auths[0].toString();
			System.out.println(tipoUsuario);
			if(tipoUsuario.equals("gerente")) {
				System.out.println("IIIIII");
				Tecnico t = fachada.obterTecnicoPorNomeUsuario(userD.getUsername());
				return ResponseEntity.status(HttpStatus.OK).body(t);
			}else {
				
				Pesquisador pesquisador = fachada.obterPesquisadorPorNome(userD.getUsername());
				return ResponseEntity.status(HttpStatus.OK).body(pesquisador);

			}

			
		}else {
			String nomeUsuario = principal.toString();
			System.out.println(nomeUsuario);
			return null;
			
			
		}
		
		
	}
	
	@GetMapping("logout")
	public ResponseEntity<String> logout() {
		
		return ResponseEntity.ok("{\"mensagem\" : \"logout\"}");
	}

}
