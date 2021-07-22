package com.ufrn.cb.SisAEL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Equipamento;

@Service
public class EquipamentoService {
	
	@Autowired
	private FachadaDados fachada;
	
	public Equipamento cadastrarEquipamento(Equipamento equip) {
		//Uma futura lógica tem que ser colocada aqui
		
		return fachada.salvarEquipamento(equip);
	}
	
	public List<Equipamento> listar(){
		
		return fachada.listarEquipamentos();
	}
}
