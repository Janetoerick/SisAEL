package com.ufrn.cb.SisAEL.service;

import java.util.List;
import java.util.Optional;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Sala;
import com.ufrn.cb.SisAEL.enums.Horarios;

public interface ReservaService {
	Reserva reservarEquipamento(Reserva reserva, List<Horarios> horarios);
	boolean cancelar(Reserva reserva);
	Optional<Reserva> manipularHorarios(Long reserva, List<Horarios> horarios);
	List<Reserva> listarTodas();
	List<Reserva> listarPorLab(Laboratorio lab);
	List<Reserva> listarPorPorSala(Sala sala);	
	List<Reserva> listarPorPesquisador(Long matPesquisador);
	List<Reserva> listarPorEquipamento(Equipamento equipamento);
}
