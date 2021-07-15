package com.ufrn.cb.SisAEL.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.enums.Horarios;
import com.ufrn.cb.SisAEL.repository.ReservaRepository;
import com.ufrn.cb.SisAEL.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService{
	
	private ReservaRepository repository;
	
	@Autowired	
	public ReservaServiceImpl(ReservaRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public Reserva reservarEquipamento(Reserva reserva, List<Horarios> horarios) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean cancelar(Reserva reserva) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Optional<Reserva> manipularHorarios(Long reserva, List<Horarios> horarios) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Reserva> listarTodas() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Reserva> listarPorLab(Laboratorio lab) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Reserva> listarPorPorSala(Sala sala) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Reserva> listarPorPesquisador(Long matPesquisador) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Reserva> listarPorEquipamento(Equipamento equipamento) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
