package com.ufrn.cb.SisAEL.dados;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Sala;

@Service
public interface FachadaDados {
	
	public Equipamento salvarEquipamento(Equipamento equipamento);
	
	public Laboratorio salvarLaboratorio(Laboratorio laboratorio);
	
	public Sala salvarSala(Sala sala);
	
	public HorarioDaReserva salvarHorario(HorarioDaReserva horario);

}
