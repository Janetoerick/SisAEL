package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Reserva;

@Service
public abstract class CalculoValorReserva {
	
	public abstract float calcular(Reserva reserva);

}
