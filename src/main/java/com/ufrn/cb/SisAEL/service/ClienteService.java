package com.ufrn.cb.SisAEL.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;
import com.ufrn.cb.SisAEL.exception.EntidadeNaoEncontradaException;

@Service
public class ClienteService {
	
	@Autowired
	FachadaDados fachada;
	
	@Autowired
	VerificadorDadosCliente verificador;
	
	public Cliente obter(String nomeUsuario) {
		Optional<Cliente> dado =  fachada.obterCliente(nomeUsuario);
		if(dado.isPresent()) {
			return dado.get();
		}else {
			
			throw new EntidadeNaoEncontradaException("Este usuário não foi encontrado");
		}
	}
	
	public Cliente cadastrar(Cliente cliente) {
		verificador.verificar(cliente);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		cliente.setSenha(encoder.encode(cliente.getSenha()));
		Cliente p = fachada.salvarCliente(cliente);
		return p;
	}
	
	public void atualizar(Cliente cliente) {
		fachada.atualizarCliente(cliente);
		
	}
	
	public List<Cliente> listar(){
		
		return fachada.listarClientes();
	}
	
	public void deletar(long id) {
		
		fachada.deletarCliente(id);
	}
	
	

}
