package com.ufrn.cb.SisAEL.service;

import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.Service;
import com.ufrn.cb.SisAEL.entity.HorarioHotel;
import com.ufrn.cb.SisAEL.entity.Reserva;

@Service
public class CalculoValorReservaHotel extends CalculoValorReserva {
	
	@Override
	public float calcular(Reserva reserva) {
		
		HorarioHotel horario = (HorarioHotel) reserva.getHorario();
		
		long dias = ChronoUnit.DAYS
					.between(horario.getDataInicial(), horario.getDataFinal());
		
		
		return dias * 35f;
	}

}
