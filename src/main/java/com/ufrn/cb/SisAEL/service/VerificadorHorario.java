package com.ufrn.cb.SisAEL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Horario;

@Service
public abstract class VerificadorHorario {
	
	@Autowired
	FachadaDados fachada;
	
	public abstract boolean ehValido(Horario horario);
	
	public abstract boolean semChoqueDeHorario(Horario horario);

}
