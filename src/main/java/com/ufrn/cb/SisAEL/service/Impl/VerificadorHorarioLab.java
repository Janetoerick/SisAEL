package com.ufrn.cb.SisAEL.service.Impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.Impl.HorarioLaboratorio;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.service.VerificadorHorario;

@Service
public class VerificadorHorarioLab extends VerificadorHorario {

	@Override
	public boolean ehValido(Horario horario) {
		
		HorarioLaboratorio h = (HorarioLaboratorio) horario;
		if(h.getData() == null || h.getHoraInicial() == null || h.getHoraFinal() == null) {
			
			return true;
		}
		
		if(h.getData().isBefore(LocalDate.now())) {
			throw new DadosInvalidosException("Data irregular");
		}
		
		if(h.getHoraInicial().isAfter(h.getHoraFinal())) {
			throw new DadosInvalidosException("Hora inicial maior que a Hora final");
		}
		
		if(h.getHoraInicial().equals(h.getHoraFinal())) {
			throw new DadosInvalidosException("Hora inicial igual a Hora final");
		}
		
		return true;
	}

}
