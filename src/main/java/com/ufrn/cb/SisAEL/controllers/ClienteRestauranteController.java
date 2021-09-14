package com.ufrn.cb.SisAEL.controllers;

import java.util.ArrayList;
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
import com.ufrn.cb.SisAEL.entity.ClienteRestaurante;

@RestController
@RequestMapping("/clientes")
public class ClienteRestauranteController extends Controller {
	
	@GetMapping("/{nomeUsuario}")
	public ResponseEntity<Cliente> obter
							(@PathVariable(value="nomeUsuario") String nome){
		
		return ResponseEntity.ok(fachada.obterCliente(nome));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<ClienteRestaurante> cadastrar(@RequestBody ClienteRestaurante clienteRestaurante){
		
		ClienteRestaurante p = (ClienteRestaurante) fachada.cadastrarCliente(clienteRestaurante);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
		
	}
	
	@PostMapping("/atualizar")
	public ResponseEntity<ClienteRestaurante> atualizar(@RequestBody ClienteRestaurante clienteRestaurante){
		
		fachada.atualizarCliente(clienteRestaurante);
		return ResponseEntity.status(HttpStatus.OK).body(clienteRestaurante);
		
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteRestaurante>> listar(){
		List<Cliente> clientes = fachada.listarClientes();
		ArrayList<ClienteRestaurante> clientesRestaurante = 
				new ArrayList<ClienteRestaurante>();
		
		for(Cliente cliente:clientes) {
			
			clientesRestaurante.add((ClienteRestaurante) cliente);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(clientesRestaurante);
		
	}
	
	@DeleteMapping("remover/{id}")
	public ResponseEntity<ClienteRestaurante> deletar(long id){
		fachada.deletarCliente(id);
		return ResponseEntity.ok(null);
		
	}
	
}
