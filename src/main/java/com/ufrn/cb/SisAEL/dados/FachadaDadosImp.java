package com.ufrn.cb.SisAEL.dados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.repository.EquipRepository;

@Service
public class FachadaDadosImp implements FachadaDados {

	@Autowired
	EquipRepository equipamentoRep;
	
	@Override
	public Equipamento salvarEquipamento(Equipamento equipamento) {
		
		Equipamento eq = equipamentoRep.save(equipamento);
		return eq;
		
		
		
	}

}
