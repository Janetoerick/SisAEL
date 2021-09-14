package com.ufrn.cb.SisAEL.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.HorarioRestaurante;

@RestController
@RequestMapping("horarios")
public class HorarioRestauranteController extends Controller{

	@PostMapping("/cadastrar")
	public ResponseEntity<HorarioRestaurante> cadastrar (@RequestBody HorarioRestaurante horario){
		HorarioRestaurante resposta = (HorarioRestaurante)fachada.cadastrarHorario(horario);
		return  ResponseEntity.status(HttpStatus.CREATED).body(resposta);
	}
	
	@GetMapping
	public ResponseEntity<List<Horario>> listar(){
		
		List<Horario> lista = fachada.listarHorarios();
		
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<HorarioRestaurante> deletar(long id){
		
		fachada.deletarHorario(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
}
