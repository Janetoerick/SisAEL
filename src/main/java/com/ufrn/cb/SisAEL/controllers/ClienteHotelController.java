package com.ufrn.cb.SisAEL.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.ClienteHotel;

@RestController
@RequestMapping("/clientes")
public class ClienteHotelController extends Controller {
	
	@GetMapping("/{nomeUsuario}")
	public ResponseEntity<Cliente> obter
							(@PathVariable(value="nomeUsuario") String nome){
		
		return ResponseEntity.ok(fachada.obterCliente(nome));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<ClienteHotel> cadastrar(@RequestBody ClienteHotel clienteHotel){
		
		ClienteHotel p = (ClienteHotel) fachada.cadastrarCliente(clienteHotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
		
	}
	
	@PostMapping("/atualizar")
	public ResponseEntity<ClienteHotel> atualizar(@RequestBody ClienteHotel clienteHotel){
		
		fachada.atualizarCliente(clienteHotel);
		return ResponseEntity.status(HttpStatus.OK).body(clienteHotel);
		
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
