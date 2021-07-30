package com.ufrn.cb.SisAEL.service;

import java.util.List;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;
import com.ufrn.cb.SisAEL.entity.ItemEquipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;

public interface FachadaService {
	
	public Equipamento cadastrarEquipamento(Equipamento equipamento);
	
	public List<Equipamento> listarEquipamentos();
	
	public ItemEquipamento cadastrarItemEquipamento(ItemEquipamento item);
	
	public Laboratorio cadastrarLaboratorio(Laboratorio laboratorio);
	
	public List<Laboratorio> listarLaboratorios();
	
	public List<ItemEquipamento> listarItensEquipamento();
	
	public HorarioDaReserva cadastrarHorario(HorarioDaReserva horario);
	
	public List<HorarioDaReserva> listarHorarios();
	
	public void deletarHorarioDaReserva(long id);
	
	public Equipamento atualizarEquipamento(Equipamento equipamento);
	

}
