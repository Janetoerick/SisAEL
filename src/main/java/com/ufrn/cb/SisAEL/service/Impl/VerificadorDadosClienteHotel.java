package com.ufrn.cb.SisAEL.service.Impl;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.impl.ClienteHotel;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.service.VerificadorDadosCliente;

@Service
public class VerificadorDadosClienteHotel extends VerificadorDadosCliente {

	@Override
	public boolean verificar(Cliente cliente) {
		
		ClienteHotel clienteHotel = (ClienteHotel) cliente;
		
		if(clienteHotel.getNome() == null || clienteHotel.getNome().length() < 3) {
			throw new DadosInvalidosException("Nome de usuario muito curto");
		}
		
		if(clienteHotel.getTelefone() == null || clienteHotel.getTelefone().length() < 5) {
			throw new DadosInvalidosException("Telefone inválido");
		}
		
		
		return true;
	}

}
