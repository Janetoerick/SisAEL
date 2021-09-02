package com.ufrn.cb.SisAEL.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping("/clientes")
public abstract class ClienteController {
	
	@Autowired
	FachadaService fachada;
	
	@GetMapping("/{nomeUsuario}")
	public ResponseEntity<Cliente> obterPorNomeUsuario(@PathVariable(value="nomeUsuario") String nome){
		
		return ResponseEntity.ok(fachada.obterCliente(nome));
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> clientes = fachada.listarClientes();
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
		
	}
	
	@DeleteMapping("remover/{id}")
	public ResponseEntity<Cliente> deletar(long id){
		fachada.deletarCliente(id);
		return ResponseEntity.ok(null);
		
	}
	
}
