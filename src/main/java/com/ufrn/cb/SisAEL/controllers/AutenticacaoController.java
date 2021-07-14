package com.ufrn.cb.SisAEL.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {
	
	
	@GetMapping("login")
	public String login() {
		
		return "Logado";
	}
	
	@GetMapping("logout")
	public String logout() {
		
		return "{\"mensagem\" : \"logout\"}";
	}

}
