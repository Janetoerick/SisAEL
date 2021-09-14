package com.ufrn.cb.SisAEL.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping("/horarios")
public abstract class HorarioController {
	
	@Autowired
	protected FachadaService fachada;
	
	@GetMapping
	public ResponseEntity<List<Horario>> listar(){
		
		List<Horario> lista = fachada.listarHorarios();
		
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<Horario> deletar(@PathVariable long id){
		
		fachada.deletarHorario(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}

}
