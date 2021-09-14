package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="horarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private boolean disponivel;
	
	@ManyToOne
	private Estoque estoque;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Estoque getEstoque() {
		return estoque;
	}
	
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	
	
	
	
	
	

}
