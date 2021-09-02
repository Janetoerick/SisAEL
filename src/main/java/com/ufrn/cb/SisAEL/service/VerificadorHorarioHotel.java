package com.ufrn.cb.SisAEL.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.HorarioLaboratorio;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class VerificadorHorarioHotel extends VerificadorHorario {

	@Override
	public boolean ehValido(Horario horario) {
		
		HorarioLaboratorio h = (HorarioLaboratorio) horario;
		if(h.getData() == null || h.getHoraInicial() == null || h.getHoraFinal() == null) {
			
			throw new DadosIncompletosException("Hora Inicial e hora Final obrigatórios");
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
