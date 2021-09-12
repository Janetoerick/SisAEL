package com.ufrn.cb.SisAEL.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.Produto;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController extends Controller {
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Equipamento> cadastrar(@RequestBody Equipamento equipamento) {
		
		Equipamento response = (Equipamento) fachada
				.cadastrarProduto(equipamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	


	@GetMapping
	public ResponseEntity<List<Equipamento>> listar(){
		
		List<Produto> produtos = fachada.listarProdutos();
		ArrayList<Equipamento> equipamentos = new ArrayList<Equipamento>();
		for(Produto produto:produtos) {
			if(produto instanceof Equipamento) {
				equipamentos.add((Equipamento) produto);
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(equipamentos);
	}
	
	@GetMapping("/{idEstoque}")
	public ResponseEntity<List<Equipamento>> listar(@RequestParam long idEstoque){
		
		List<Produto> produtos = fachada.listarProdutos();
		ArrayList<Equipamento> equipamentos = new ArrayList<Equipamento>();
		for(Produto produto:produtos) {
			if(produto instanceof Equipamento) {
				equipamentos.add((Equipamento) produto);
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(equipamentos);		
	}
	
	
	
	
	

}
