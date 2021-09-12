package com.ufrn.cb.SisAEL.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ufrn.cb.SisAEL.entity.Admin;

@RestController
@RequestMapping("/admins")
public class AdminController extends Controller{
	
	
	@GetMapping("/{nomeUsuario}")
	public ResponseEntity<Admin> obter(String nomeUsuario){
		
		Admin admin = fachada.obterAdmin(nomeUsuario);
		return ResponseEntity.status(HttpStatus.OK).body(admin);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Admin> cadastrar(@RequestBody Admin admin) {
		
		Admin adm = fachada.cadastrarAdmin(admin);
		return ResponseEntity.status(HttpStatus.CREATED).body(adm);
		
	}

}
