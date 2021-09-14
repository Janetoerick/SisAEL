package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.ClienteRestaurante;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class VerificadorDadosClienteImpl extends VerificadorDadosCliente {

	@Override
	public boolean verificar(Cliente cliente) {
		
		ClienteRestaurante clienteHotel = (ClienteRestaurante) cliente;
		
		if(clienteHotel.getNome() == null || clienteHotel.getNome().length() < 3) {
			throw new DadosInvalidosException("Nome de usuario muito curto");
		}
		
		return true;
	}

}
