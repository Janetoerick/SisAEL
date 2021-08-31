package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Horario;

@Service
public class VerificadorHorario {
	
	public boolean ehValido(Horario horario) {
		
		return true;
	}

}
