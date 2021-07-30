package com.ufrn.cb.SisAEL.dados;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;
import com.ufrn.cb.SisAEL.entity.ItemEquipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Sala;

@Service
public interface FachadaDados {
	
	public Equipamento obterEquipamentoPorId(long id);
	
	public Equipamento salvarEquipamento(Equipamento equipamento);
	
	public ItemEquipamento salvarItemEquipamento(ItemEquipamento item);
	
	public List<Equipamento> listarEquipamentos();
	
	public List<ItemEquipamento> listarItensEquipamentos();
	
	public Laboratorio salvarLaboratorio(Laboratorio laboratorio);
	
	public List<Laboratorio> listarLaboratorios();
	
	public Sala salvarSala(Sala sala);
	
	public HorarioDaReserva salvarHorario(HorarioDaReserva horario);
	
	public List<HorarioDaReserva> listarHorarios();
	
	public void deletarHorarioDaReserva(long id);
	
	public Equipamento atualizarEquipamento(Equipamento equipamento);
	
	public void atualizarNomeEquipamento(long id, String nome);
	
	public void atualizarQuantidadeEquipamento(long id, int quantidade);
	
	

}
