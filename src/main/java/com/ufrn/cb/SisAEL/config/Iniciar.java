package com.ufrn.cb.SisAEL.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.Admin;
import com.ufrn.cb.SisAEL.service.FachadaService;

@Component
public class Iniciar implements CommandLineRunner{
	
	@Autowired
	FachadaService fachada;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Cliente p = new Cliente();
//		p.(12345678L);
//		p.setNome("Fulando da Silva");
//		p.setNomeUsuario("pesquisador");
//		p.setSenha("12345");
//		p.setCargo("pesquisador");
//		p.setEmail("pesquisador@ufrn.edu.br");
		
		
		/*Admin t = new Admin();
		t.setNome("Fulano Medeiros");
		t.setNomeUsuario("tecnico");
		t.setSenha("12345");
		t.setCargo("gerente");
	
		
//		fachada.cadastrarPesquisador(p);
		fachada.cadastrarAdmin(t); */
		
	}

}
