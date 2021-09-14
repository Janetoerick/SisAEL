package com.ufrn.cb.SisAEL.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.HorarioRestaurante;
import com.ufrn.cb.SisAEL.exception.ColisaoDeHorarioException;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class VerificadorHorarioRestaurante extends VerificadorHorario {

	@Override
	public boolean ehValido(Horario horario) {
		
		HorarioRestaurante h = (HorarioRestaurante) horario;
		if(h.getHora() == null || h.getData()== null) {
			
			throw new DadosIncompletosException("A reserva "
					+ "precisa de uma data e uma hora");
		}
		
		if(h.getData().isBefore(LocalDate.now())) {
			throw new DadosInvalidosException("Data anterior à data atual");
		}
		
	
		return true;
	}

	@Override
	public boolean semChoqueDeHorario(Horario horario) {
		
		/*HorarioRestaurante novoHorario = (HorarioRestaurante) horario;
		List<Horario> horarios = fachada.listarHorarios();
		for(Horario h: horarios) {
			HorarioRestaurante hRest = (HorarioRestaurante) h;
			if(h.equals(novoHorario)) {
				throw new ColisaoDeHorarioException("Colisão com: " 
						+ hRest.toString());
			}
		} */
		
		return true;
	}

}
