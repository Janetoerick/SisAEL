package com.ufrn.cb.SisAEL.dados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.repository.EquipRepository;
import com.ufrn.cb.SisAEL.repository.LabRepository;
import com.ufrn.cb.SisAEL.repository.SalaRepository;

@Service
public class FachadaDadosImp implements FachadaDados {

	@Autowired
	EquipRepository equipamentoRep;
	
	@Autowired
	LabRepository laboratorioRep;
	
	@Autowired
	SalaRepository salaRepository;
	
	@Override
	public Equipamento salvarEquipamento(Equipamento equipamento) {
		
		Equipamento eq = equipamentoRep.save(equipamento);
		return eq;
		
		
		
	}

	@Override
	public Laboratorio salvarLaboratorio(Laboratorio laboratorio) {
		
		Laboratorio lab = laboratorioRep.save(laboratorio);
		return lab;
	}

	@Override
	public Sala salvarSala(Sala sala) {
		
		return salaRepository.save(sala);
	}

}
