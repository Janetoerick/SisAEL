package com.ufrn.cb.SisAEL.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.entity.Tecnico;
import com.ufrn.cb.SisAEL.service.FachadaService;

@Component
public class Iniciar implements CommandLineRunner{
	
	@Autowired
	FachadaService fachada;
	
	@Override
	public void run(String... args) throws Exception {
		
		Pesquisador p = new Pesquisador();
		p.setMatricula(12345678L);
		p.setNome("Fulando da Silva");
		p.setNomeUsuario("pesquisador");
		p.setSenha("12345");
		p.setRole("pesquisador");
		p.setEmail("pesquisador@ufrn.edu.br");
		
		
		Tecnico t = new Tecnico();
		t.setNome("Fulano Medeiros");
		t.setNomeUsuario("tecnico");
		t.setSenha("12345");
		t.setRole("gerente");
	
		
		fachada.cadastrarPesquisador(p);
		fachada.cadastrarTecnico(t);
		
	}

}
