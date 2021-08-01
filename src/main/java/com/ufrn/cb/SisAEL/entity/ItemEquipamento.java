package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itens_equipamento")
public class ItemEquipamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private int tombamento;
	
	@ManyToOne
	private Equipamento equipamento;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTombamento() {
		return tombamento;
	}

	public void setTombamento(int tombamento) {
		this.tombamento = tombamento;
	}

	@ManyToOne
	@JoinColumn(name="id_equipamento")
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	
	

}
