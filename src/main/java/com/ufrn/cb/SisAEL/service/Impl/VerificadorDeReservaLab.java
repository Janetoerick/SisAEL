package com.ufrn.cb.SisAEL.service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Impl.HorarioLaboratorio;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.exception.ReservaException;
import com.ufrn.cb.SisAEL.service.VerificadorDeReserva;

@Service
public class VerificadorDeReservaLab extends VerificadorDeReserva{

	@Override
	protected boolean verificarDisponibilidade(Reserva reserva) {
		
		List<Produto> produtos = reserva.getProdutos();
		
		for (Produto produto : produtos) {
			
			if(!produto.isDisponivel()) {
				throw new ReservaException("Produto indisponível: " + produto.getEstoque().getNome());
			}
		}
		
		List<Reserva> reservas = fachada.listarReservas();
		
		for (Reserva r : reservas) {
			HorarioLaboratorio horario = (HorarioLaboratorio) r.getHorario();
			for (int i = 0; i < reserva.getProdutos().size(); i++) {
				if(r.getProdutos().contains(reserva.getProdutos().get(i))) {
					HorarioLaboratorio horario_t = (HorarioLaboratorio) reserva.getHorario();
					if(horario.getData().isEqual(horario_t.getData())) {
						if(!horario.getHoraInicial().isAfter(horario_t.getHoraFinal()) && !horario.getHoraFinal().isBefore(horario_t.getHoraFinal())
								|| !horario.getHoraInicial().isAfter(horario_t.getHoraInicial()) && !horario.getHoraFinal().isBefore(horario_t.getHoraInicial())
								|| !horario.getHoraInicial().isBefore(horario_t.getHoraInicial()) && !horario.getHoraFinal().isAfter(horario_t.getHoraFinal())) {
							throw new ReservaException("Produto " + reserva.getProdutos().get(i).getId() + " indisponível no horario"); 
							
						}	
					}
				}
			}
		}
		
		return true;
	}

}
