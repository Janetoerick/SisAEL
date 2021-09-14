package com.ufrn.cb.SisAEL.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Sala;

@RestController
@RequestMapping("/salas")
public class SalaController extends Controller {

	@PostMapping("/cadastrar")
	public ResponseEntity<Sala> cadastrar(Sala sala) {
		
		Sala response = (Sala)fachada.cadastrarProduto(sala);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Sala>> listar() {
		
		List<Produto> produtos = fachada.listarProdutos();
		ArrayList<Sala> salas = new ArrayList<Sala>();
		for(Produto produto: produtos) {
			
			if(produto instanceof Sala) {
				salas.add((Sala) produto);
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(salas);
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Sala> deletar(@PathVariable long id){
		
		fachada.deletarProduto(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
}
