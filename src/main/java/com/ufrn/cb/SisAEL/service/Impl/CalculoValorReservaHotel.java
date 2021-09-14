package com.ufrn.cb.SisAEL.service.Impl;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.impl.HorarioHotel;
import com.ufrn.cb.SisAEL.exception.ReservaException;
import com.ufrn.cb.SisAEL.service.CalculoValorReserva;

@Service
public class CalculoValorReservaHotel extends CalculoValorReserva {
	
	public float calcular(Reserva reserva) {
		
		
		
		LocalDate dataInicial = ((HorarioHotel) reserva
				.getHorario()).getDataInicial();
		
		LocalDate dataFinal = ((HorarioHotel) reserva
				.getHorario()).getDataFinal();
		
		if(dataInicial == null || dataFinal == null) {
			throw new ReservaException
				("É nescessário uma data inicial e final para calcular o valor");
		}
		
		Period p = Period.between(dataInicial, dataFinal);
		int diasDeHospedagem = p.getDays();
		
		return 30 * (float) diasDeHospedagem;
	}

}
