package com.ufrn.cb.SisAEL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;

@Service
public class HorariosService {
	
	@Autowired
	private FachadaDados fachada;
	
	public HorarioDaReserva cadastrar(HorarioDaReserva horario) {
		
		HorarioDaReserva h = fachada.salvarHorario(horario);
		
		return h;
		
	}
	
	public List<HorarioDaReserva> listarHorarios(){
	
		return fachada.listarHorarios();
	}
	
	

}
