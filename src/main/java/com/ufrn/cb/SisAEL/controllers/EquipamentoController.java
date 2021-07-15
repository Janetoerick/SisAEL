package com.ufrn.cb.SisAEL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping("equipamentos")
public class EquipamentoController {
	
	@Autowired
	FachadaService fachada;
	
	@PostMapping("cadastrar")
	public Equipamento cadastrar(Equipamento equipamento) {
		
		return fachada.cadastrarEquipamento(equipamento);
	}

}
