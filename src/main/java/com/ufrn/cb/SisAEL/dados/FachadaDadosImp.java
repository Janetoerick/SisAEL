package com.ufrn.cb.SisAEL.dados;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.repository.EquipRepository;
import com.ufrn.cb.SisAEL.repository.LabRepository;
import com.ufrn.cb.SisAEL.repository.SalaRepository;
import com.ufrn.cb.SisAEL.repository.HorariosDaReservaRepository;

@Service
public class FachadaDadosImp implements FachadaDados {

	@Autowired
	EquipRepository equipamentoRep;
	
	@Autowired
	LabRepository laboratorioRep;
	
	@Autowired
	SalaRepository salaRepository;
	
	@Autowired
	HorariosDaReservaRepository horarioRepository;
	
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

	@Override
	public HorarioDaReserva salvarHorario(HorarioDaReserva horario) {
		HorarioDaReserva repository = horarioRepository.save(horario);
		return repository;
	}

	@Override
	public List<HorarioDaReserva> listarHorarios() {
		
		return horarioRepository.findAll();
	}

	@Override
	public void deletarHorarioDaReserva(long id) {
		
		horarioRepository.deleteById(id);
	}
	
	

}
