package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Cliente;

@Service
public abstract class VerificadorDadosCliente {
	
	public abstract boolean verificar(Cliente cliente);
}