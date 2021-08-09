package com.ufrn.cb.SisAEL.dados;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;
import com.ufrn.cb.SisAEL.entity.ItemEquipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.entity.Reserva;
import com.ufrn.cb.SisAEL.entity.Sala;

@Service
public interface FachadaDados {
	
	public Equipamento obterEquipamentoPorId(long id);
	
	public  Optional<Reserva> obterReserva(long idLab, long idSala,LocalDate data,long idHorario);
	
	public Equipamento salvarEquipamento(Equipamento equipamento);
	
	public Pesquisador salvarPesquisador(Pesquisador pesquisador);
	
	public ItemEquipamento salvarItemEquipamento(ItemEquipamento item);
	
	public Reserva salvarReserva(Reserva reserva);
	
	public List<Equipamento> listarEquipamentos();
	
	public List<ItemEquipamento> listarItensEquipamentos();
	
	public Laboratorio salvarLaboratorio(Laboratorio laboratorio);
	
	public List<Laboratorio> listarLaboratorios();
	
	public Sala salvarSala(Sala sala);
	
	public HorarioDaReserva salvarHorario(HorarioDaReserva horario);
	
	public List<HorarioDaReserva> listarHorarios();
	
	public List<Reserva> listarReservas();
	
	public void deletarHorarioDaReserva(long id);
	
	public Equipamento atualizarEquipamento(Equipamento equipamento);
	
	public void atualizarNomeEquipamento(long id, String nome);
	
	public void atualizarQuantidadeEquipamento(long id, int quantidade);
	
	public List<ItemEquipamento> listarItens(long idTipoEquipamento);
	
	public Optional<Pesquisador> obterPesquisadorPorNome(String nomeUsuario);
	
	
	
	

}
