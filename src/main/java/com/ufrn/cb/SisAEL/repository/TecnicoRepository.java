package com.ufrn.cb.SisAEL.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.Tecnico;

@Transactional
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long>{
	
	@Transactional
	@Query(value="select t from Tecnico t where t.nomeUsuario =:nomeUsuario")
	Optional<Tecnico> obterPorNomeUsuario(String nomeUsuario);
	
}