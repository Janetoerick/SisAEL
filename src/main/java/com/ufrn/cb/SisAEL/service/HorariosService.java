package com.ufrn.cb.SisAEL.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;
import com.ufrn.cb.SisAEL.exception.ColisaoDeHorarioException;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class HorariosService {
	
	@Autowired
	private FachadaDados fachada;
	
	public HorarioDaReserva cadastrar(HorarioDaReserva horario) {
		
		if(horario == null || horario.getHoraInicial()
				.equals(horario.getHoraFinal()) || horario
				.getHoraInicial().isAfter(horario.getHoraFinal())) {
			
			throw new DadosInvalidosException("Dados inválidos");
			
		}
		
		List<HorarioDaReserva> horarios = fachada.listarHorarios();
		for (HorarioDaReserva h : horarios) {

			if((horario.getHoraInicial().equals(h.getHoraInicial()) && 
					horario.getHoraFinal().equals(h.getHoraFinal())) ||
					
					(horario.getHoraInicial().equals(h.getHoraInicial()) &&
					 horario.getHoraFinal().isAfter(h.getHoraFinal())) ||
					
				   (horario.getHoraInicial().isAfter(h.getHoraInicial()) &&
					horario.getHoraInicial().isBefore(h.getHoraFinal())) ||
					
					
					(horario.getHoraInicial().isBefore(h.getHoraInicial()) &&
					 h.getHoraInicial().isBefore(horario.getHoraFinal())) ||
					 
					(horario.getHoraInicial().equals(h.getHoraInicial()) &&
					 horario.getHoraFinal().isBefore(h.getHoraFinal()))){
				
				
				throw new ColisaoDeHorarioException("Colisão com: "
								+h.getHoraInicial()+" - " + h.getHoraFinal());
				
			}
		}
		
		HorarioDaReserva h = fachada.salvarHorario(horario);
		return h;
		
	}
	
	public List<HorarioDaReserva> listarHorarios(){
		
		
	
		ArrayList<HorarioDaReserva> horarios = 
				(ArrayList<HorarioDaReserva>) fachada.listarHorarios();
		

		for(int i = 0;i < horarios.size() - 1;i++) {
			for(int j = i+1;j < horarios.size();j++) {
				if(horarios.get(i).getHoraInicial()
						.isAfter(horarios.get(j).getHoraInicial())) {
					HorarioDaReserva temp = horarios.get(i);
					horarios.set(i, horarios.get(j));
					horarios.set(j, temp);
				}
			}
		}
		return horarios;
	}
	
	public void deletarHorario(long id) {
		
		fachada.deletarHorarioDaReserva(id);
	}
	

}
