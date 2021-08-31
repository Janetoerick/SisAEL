package com.ufrn.cb.SisAEL.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.exception.ColisaoDeHorarioException;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class HorarioService {
	
	@Autowired
	private FachadaDados fachada;
	
	@Autowired
	private VerificadorHorario verificadorHorario;
	
	public Horario cadastrar(Horario horario) {
		
		boolean horarioValido = verificadorHorario.ehValido(horario);
		if(!horarioValido) {
			
			throw new DadosInvalidosException("Horário Inválido");
		}
		
		return fachada.salvarHorario(horario);
		
	}
	
	public List<Horario> listarHorarios(){
		
		
	
		ArrayList<Horario> horarios = 
				(ArrayList<Horario>) fachada.listarHorarios();
		
		return horarios;
	}
	
	public void deletarHorario(long id) {
		
		fachada.deletarHorario(id);
	}
	

}
