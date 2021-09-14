package com.ufrn.cb.SisAEL.service;

import java.time.LocalDate;
import org.springframework.stereotype.Service;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.HorarioHotel;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class VerificadorHorarioHotel extends VerificadorHorario {

	@Override
	public boolean ehValido(Horario horario) {
		
		HorarioHotel h = (HorarioHotel) horario;
		if(h.getDataInicial() == null || h.getDataFinal()== null) {
			
			throw new DadosIncompletosException("Data Inicial"
					+ " e Data Final não podem ser NULL");
		}
		
		if(h.getDataInicial().isBefore(LocalDate.now())) {
			throw new DadosInvalidosException("Data anterior à data atual");
		}
		
		if(h.getDataInicial().isAfter(h.getDataFinal())) {
			throw new DadosInvalidosException("Data inicial maior que a data final");
		}
		
		return true;
	}

	@Override
	public boolean semChoqueDeHorario(Horario horario) {
		
		//fachada.salvarHorario(horario);
		return true;
	}

}
