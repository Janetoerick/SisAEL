package com.ufrn.cb.SisAEL.dados;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;

@Service
public interface FachadaDados {
	
	public Equipamento salvarEquipamento(Equipamento equipamento);

}
