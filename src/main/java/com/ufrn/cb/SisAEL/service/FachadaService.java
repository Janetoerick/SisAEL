package com.ufrn.cb.SisAEL.service;

import java.util.List;
import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;
import com.ufrn.cb.SisAEL.entity.ItemEquipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.entity.Reserva;

public interface FachadaService {
	
	public Equipamento cadastrarEquipamento(Equipamento equipamento);
	
	public Reserva cadastrarReserva(Reserva reserva);
	
	public Pesquisador cadastrarPesquisador(Pesquisador pesquisador);
	
	public List<Equipamento> listarEquipamentos();
	
	public ItemEquipamento cadastrarItemEquipamento(ItemEquipamento item);
	
	public Laboratorio cadastrarLaboratorio(Laboratorio laboratorio);
	
	public List<Laboratorio> listarLaboratorios();
	
	public List<ItemEquipamento> listarItensEquipamento();
	
	public List<Reserva> listarReservas();
	
	public HorarioDaReserva cadastrarHorario(HorarioDaReserva horario);
	
	public List<HorarioDaReserva> listarHorarios();
	
	public void deletarHorarioDaReserva(long id);
	
	public Equipamento atualizarEquipamento(Equipamento equipamento);
	
	public List<ItemEquipamento> listarItensEquipamentos(long idTipoEquipamento);
	
	public Pesquisador obterPesquisadorPorNome(String nome);
	
	
	

}
