package com.ufrn.cb.SisAEL.service.Impl;

import java.time.Duration;
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
		
		return 0;
	}

}
