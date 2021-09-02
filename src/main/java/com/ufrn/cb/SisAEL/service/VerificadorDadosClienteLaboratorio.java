package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.ClienteHotel;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class VerificadorDadosClienteLaboratorio extends VerificadorDadosCliente {

	@Override
	public boolean verificar(Cliente cliente) {
		
		
		
		
		return true;
	}

}
