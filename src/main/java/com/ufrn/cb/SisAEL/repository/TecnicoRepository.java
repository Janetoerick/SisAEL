package com.ufrn.cb.SisAEL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.Tecnico;

@Transactional
public interface TecnicoRepository extends JpaRepository<Tecnico, Long>{
	Tecnico findBylogin(String login);
}