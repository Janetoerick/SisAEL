package com.ufrn.cb.SisAEL.dados;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Sala;

@Service
public interface FachadaDados {
	
	public Equipamento salvarEquipamento(Equipamento equipamento);
	
	public List<Equipamento> listarEquipamentos();
	
	public Laboratorio salvarLaboratorio(Laboratorio laboratorio);
	
	public List<Laboratorio> listarLaboratorios();
	
	public Sala salvarSala(Sala sala);
	
	public HorarioDaReserva salvarHorario(HorarioDaReserva horario);
	
	public List<HorarioDaReserva> listarHorarios();
	
	public void deletarHorarioDaReserva(long id);
	
	

}
