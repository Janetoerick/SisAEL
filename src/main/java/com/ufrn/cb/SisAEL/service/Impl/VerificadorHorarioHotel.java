package com.ufrn.cb.SisAEL.service.Impl;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.impl.HorarioHotel;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.service.VerificadorHorario;

@Service
public class VerificadorHorarioHotel extends VerificadorHorario {

	@Override
	public boolean ehValido(Horario horario) {
		
		HorarioHotel h = (HorarioHotel) horario;
		if(h.getDataInicial() == null || h.getDataFinal() == null) {
			
			throw new DadosIncompletosException("Data Inicial e data Final obrigatórios");
		}
		
		if(h.getDataInicial().equals(h.getDataFinal())) {
			throw new DadosInvalidosException("Mesma data");
		}
		if(h.getDataInicial().isAfter(h.getDataFinal())) {
			throw new DadosInvalidosException("Data inicial maior que a data final");
		}
		
		return true;
	}

}
