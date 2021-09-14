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
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.HorarioLaboratorio;

@RestController
@RequestMapping("/horarios")
public class HorarioController extends Controller{
	
	@PostMapping("/cadastrar")
	public ResponseEntity<HorarioLaboratorio> cadastrar
									(@RequestBody HorarioLaboratorio horario){
		
		HorarioLaboratorio h = (HorarioLaboratorio) fachada.cadastrarHorario(horario);
		return ResponseEntity.status(HttpStatus.CREATED).body(h);
	}
	
	@GetMapping
	public ResponseEntity<List<HorarioLaboratorio>> listar(){
		
		List<Horario> lista = fachada.listarHorarios();
		ArrayList<HorarioLaboratorio> lista2 = 
				new ArrayList<HorarioLaboratorio>();
		
		for(Horario l:lista) {
			lista2.add((HorarioLaboratorio)l);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(lista2);
	}
	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<HorarioLaboratorio> deletar(@PathVariable long id){
		
		fachada.deletarHorario(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}

}
