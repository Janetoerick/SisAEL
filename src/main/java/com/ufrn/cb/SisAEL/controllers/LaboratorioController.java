package com.ufrn.cb.SisAEL.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Sala;

@RestController
@RequestMapping("laboratorios")
public class LaboratorioController extends Controller {
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Laboratorio> cadastrar(@RequestBody Laboratorio lab){
		

		Laboratorio laboratorio = (Laboratorio) fachada.cadastrarProduto(lab);
		return ResponseEntity.status(HttpStatus.CREATED).body(laboratorio);
	}
	
	@GetMapping
	public ResponseEntity<List<Laboratorio>> listar(){
		
		List<Produto> produtos = fachada.listarProdutos();
		ArrayList<Laboratorio> laboratorios = new ArrayList<Laboratorio>();
		for(Produto produto: produtos) {
			if(produto instanceof Laboratorio) {
				
				laboratorios.add((Laboratorio)produto);
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(laboratorios);
	}
	

	

}
