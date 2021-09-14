package com.ufrn.cb.SisAEL.service.Impl;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.Impl.ClienteRestaurante;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.service.VerificadorDadosCliente;

@Service
public class VerificadorDadosClienteRestaurante extends VerificadorDadosCliente {

	@Override
	public boolean verificar(Cliente cliente) {
		
		ClienteRestaurante c = (ClienteRestaurante) cliente;
		
		if(c.getNome() == null || c.getNome().length() < 3) {
			throw new DadosInvalidosException("Nome de usuario muito curto");
		}
		
		if(c.getTelefone() == null || c.getTelefone().length() < 5) {
			throw new DadosInvalidosException("Telefone inválido");
		}
		
		if(c.getEmail() == null || c.getEmail().length() < 10) {
			throw new DadosInvalidosException("Email inválido");
		}
		
		return true;
	}

}
