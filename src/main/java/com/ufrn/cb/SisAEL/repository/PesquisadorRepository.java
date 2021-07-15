package com.ufrn.cb.SisAEL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.Pesquisador;

@Transactional
@Repository
public interface PesquisadorRepository extends JpaRepository<Pesquisador,Long>{
	
}
