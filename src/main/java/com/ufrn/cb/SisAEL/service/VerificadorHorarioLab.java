package com.ufrn.cb.SisAEL.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.HorarioLaboratorio;
import com.ufrn.cb.SisAEL.exception.ColisaoDeHorarioException;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class VerificadorHorarioLab extends VerificadorHorario {

	@Override
	public boolean ehValido(Horario horario) {
		
		HorarioLaboratorio h = (HorarioLaboratorio) horario;
		if(h.getData() == null || h.getHoraInicial() == null || h.getHoraFinal() == null) {
			
			throw new DadosIncompletosException("Data ou horarios não podem ser null");
		}
		
		if(h.getData().isBefore(LocalDate.now())) {
			throw new DadosInvalidosException("Data anterior à data atual");
		}
		
		if(h.getHoraInicial().isAfter(h.getHoraFinal())) {
			throw new DadosInvalidosException("Hora inicial maior que a Hora final");
		}
		
		if(h.getHoraInicial().equals(h.getHoraFinal())) {
			throw new DadosInvalidosException("Hora inicial igual a Hora final");
		}
		
		return true;
	}

	@Override
	public boolean semChoqueDeHorario(Horario horario) {
		HorarioLaboratorio novoHorario = (HorarioLaboratorio) horario;
		List<Horario> horarios = fachada.listarHorarios();
		List<HorarioLaboratorio> horariosLab = new ArrayList<HorarioLaboratorio>();
		
		for(Horario h : horarios) {
			
			if (((HorarioLaboratorio) h).getData()
					.equals(novoHorario.getData())) {
				horariosLab.add((HorarioLaboratorio)h);
			}
		}
		
		for (HorarioLaboratorio hCad : horariosLab) {
			if(!((novoHorario.getHoraInicial().isBefore(hCad.getHoraInicial()) 
					&& (novoHorario.getHoraFinal().equals(hCad.getHoraInicial())
					|| novoHorario.getHoraFinal().isBefore(hCad.getHoraInicial()))
					) 
					||
					((novoHorario.getHoraInicial().equals(hCad.getHoraFinal()) 
							|| novoHorario.getHoraInicial().isAfter(hCad.getHoraFinal()))
							&& novoHorario.getHoraFinal().isAfter(hCad.getHoraFinal())))) {
				
				throw new ColisaoDeHorarioException("Choque com + " + hCad.toString());
			}
			
			
		}
		
		return true;
	}

}
