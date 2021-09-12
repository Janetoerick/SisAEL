package com.ufrn.cb.SisAEL.service;

import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.exception.DadosIncompletosException;

public class SalaValidatorStrategy implements ValidatorStrategy {

	@Override
	public boolean validar(Produto produto) {
		
		Sala sala = (Sala) produto;
		if(sala.getNome()==null) {
			
			throw new DadosIncompletosException("Coloque o nome da sala");
		}
		
		return true;
	}

}
