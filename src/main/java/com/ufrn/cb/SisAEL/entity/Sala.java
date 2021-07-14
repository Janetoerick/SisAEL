package com.ufrn.cb.SisAEL.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sala")
public class Sala {
	
	@Id
	@Column(name="idSala")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="idLab")
	private Long idLab;
	
	@Column(name="nome")
	private String nome;

	public Sala() {
		super();
	}

	public Sala(Long id, Long lab, String nome) {
		super();
		this.id = id;
		this.idLab = lab;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLab() {
		return idLab;
	}

	public void setLab(Long lab) {
		this.idLab = lab;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
