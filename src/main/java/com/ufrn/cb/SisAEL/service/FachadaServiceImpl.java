package com.ufrn.cb.SisAEL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;


@Service
public class FachadaServiceImpl implements FachadaService{

	@Autowired
	EquipamentoService equipService;
	
	@Override
	public Equipamento cadastrarEquipamento(Equipamento equipamento) {
		return equipService.cadastrarEquipamento(equipamento);
	}

}
