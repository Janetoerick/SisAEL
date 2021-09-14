package com.ufrn.cb.SisAEL.service.Impl;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.service.CalculoValorReserva;

@Service
public class CalculoValorReservaRestaurante extends CalculoValorReserva {
	
	public float calcular(Reserva reserva) {
		return 10;
	}

}
