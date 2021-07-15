package com.ufrn.cb.SisAEL.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	@JoinColumn(name="id_equipamento")
	private List<Equipamento> equipamentos;
	
	@ManyToOne
	@JoinColumn(name = "id_pesquisador")
	private Pesquisador pesquisador;
	
	@OneToOne
	@JoinColumn(name="id_horario_da_reserva")
	private HorarioDaReserva horarioDaReserva;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public Pesquisador getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(Pesquisador pesquisador) {
		this.pesquisador = pesquisador;
	}

	public HorarioDaReserva getHorarioDaReserva() {
		return horarioDaReserva;
	}

	public void setHorarioDaReserva(HorarioDaReserva horarioDaReserva) {
		this.horarioDaReserva = horarioDaReserva;
	}
	
	
	
	
	
	


	
	
	
	
	
	
}
