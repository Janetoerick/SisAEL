package com.ufrn.cb.SisAEL.controllers.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.controllers.HorarioController;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Impl.HorarioRestaurante;

@RestController
public class HorarioControllerImpl extends HorarioController {
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Horario> cadastrar(@RequestBody HorarioRestaurante horario) {
		
		Horario horarioDaReserva= fachada.cadastrarHorario(horario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(horarioDaReserva);
		
	}

}
