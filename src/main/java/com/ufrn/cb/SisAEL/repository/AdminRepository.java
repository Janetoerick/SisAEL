package com.ufrn.cb.SisAEL.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.Admin;

@Transactional
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	@Transactional
	@Query(value="select t from Tecnico t where t.nomeUsuario =:nomeUsuario")
	Optional<Admin> obterPorNomeUsuario(String nomeUsuario);
	
}