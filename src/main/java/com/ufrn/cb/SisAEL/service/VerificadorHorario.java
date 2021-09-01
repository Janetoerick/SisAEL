package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Horario;

@Service
public abstract class VerificadorHorario {
	
	public abstract boolean ehValido(Horario horario);

}
