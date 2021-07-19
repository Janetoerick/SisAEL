package com.ufrn.cb.SisAEL.service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;

public interface FachadaService {
	
	public Equipamento cadastrarEquipamento(Equipamento equipamento);
	
	public Laboratorio cadastrarLaboratorio(Laboratorio laboratorio);

}
