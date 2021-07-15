package com.ufrn.cb.SisAEL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.Tecnico;

@Transactional
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long>{
	
}