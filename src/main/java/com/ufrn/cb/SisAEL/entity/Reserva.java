package com.ufrn.cb.SisAEL.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	@JoinColumn(name="id_equipamento")
	private List<ItemEquipamento> equipamentos;
	
	@ManyToOne
	@JoinColumn(name = "id_pesquisador")
	private Pesquisador pesquisador;
	
	@ManyToOne
	@JoinColumn(name="id_horario_da_reserva")
	private HorarioDaReserva horarioDaReserva;
	
	@ManyToOne
	@JoinColumn(name="id_laboratorio")
	private Laboratorio laboratorio;

	@ManyToOne
	@JoinColumn(name="id_sala")
	private Sala sala;
	
	private LocalDate data;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemEquipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<ItemEquipamento> equipamentos) {
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

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	
	
	
	


	
	
	
	
	
	
}
