package com.ufrn.cb.SisAEL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Laboratorio;

@Service
public class LaboratorioService {
	
	@Autowired
	FachadaDados fachada;
	
	public Laboratorio cadastrar(Laboratorio lab) {
		
		return fachada.salvarLaboratorio(lab);
	}
	
	public List<Laboratorio> listar(){
		
		return fachada.listarLaboratorios();
	}

}
