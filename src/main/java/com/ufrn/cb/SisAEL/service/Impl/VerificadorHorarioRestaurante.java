package com.ufrn.cb.SisAEL.service.Impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Impl.HorarioRestaurante;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.service.VerificadorHorario;

@Service
public class VerificadorHorarioRestaurante extends VerificadorHorario {

	@Override
	public boolean ehValido(Horario horario) {
		
		HorarioRestaurante h = (HorarioRestaurante) horario;
		if(h.getData() == null || h.getHora() == null) {
			throw new DadosInvalidosException("Dado Incompleto");
		}
		
		if(h.getData().isBefore(LocalDate.now())) {
			throw new DadosInvalidosException("Data irregular");
		}
		
		return true;
	}

}
