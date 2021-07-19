package com.ufrn.cb.SisAEL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;
import com.ufrn.cb.SisAEL.entity.Laboratorio;


@Service
public class FachadaServiceImpl implements FachadaService{

	@Autowired
	EquipamentoService equipService;
	
	@Autowired
	LaboratorioService labService;
	
	@Autowired
	HorariosService horarioService;
	
	@Override
	public Equipamento cadastrarEquipamento(Equipamento equipamento) {
		return equipService.cadastrarEquipamento(equipamento);
	}

	@Override
	public Laboratorio cadastrarLaboratorio(Laboratorio laboratorio) {
		
		return labService.cadastrar(laboratorio);
	}

	@Override
	public HorarioDaReserva cadastrarHorario(HorarioDaReserva horario) {
		
		return horarioService.cadastrar(horario);
	}

}
