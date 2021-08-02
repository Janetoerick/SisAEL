package com.ufrn.cb.SisAEL.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.Pesquisador;

@Transactional
@Repository
public interface PesquisadorRepository extends JpaRepository<Pesquisador,Long>{
	
	@Query("Select p from Pesquisador p where p.nomeUsuario = :nomeUsuario")
	public Optional<Pesquisador> obterPorNomeUsuario(@Param(value = "nomeUsuario") String nomeUsuario);
	
}
