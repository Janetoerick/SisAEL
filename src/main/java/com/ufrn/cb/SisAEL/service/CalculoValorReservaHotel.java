package com.ufrn.cb.SisAEL.service;



import org.springframework.stereotype.Service;
import com.ufrn.cb.SisAEL.entity.Reserva;

@Service
public class CalculoValorReservaHotel extends CalculoValorReserva {
	
	@Override
	public float calcular(Reserva reserva) {
		
		return 0;
	}

}
