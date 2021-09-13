package com.ufrn.cb.SisAEL.controllers.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.controllers.ClienteController;
import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.impl.ClienteHotel;

@RestController
public class ClienteControllerImpl extends ClienteController{

	@PostMapping("/cadastrar")
	public ResponseEntity<Cliente> cadastrar(@RequestBody ClienteHotel cliente){
		
		Cliente p = fachada.cadastrarCliente(cliente);
		return ResponseEntity.ok(p);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Cliente> atualizar(@RequestBody ClienteHotel cliente){
		
		fachada.atualizarCliente(cliente);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}
	
	
}
