package com.ufrn.cb.SisAEL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.Estoque;

@Transactional
@Repository
public interface EquipRepository extends JpaRepository<Estoque, Long> {
	
	@Modifying
	@Transactional
	@Query("update Equipamento e set e.nome = :nome where e.id = :id")
	void atualizarNome(@Param(value="id") long id,
			@Param(value="nome") String nome);
	
	@Modifying
	@Transactional
	@Query("update Equipamento e set e.quantidade = :quantidade where e.id = :id")
	void atualizarQuantidade(@Param(value="id") long id,
			@Param(value="quantidade") int quantidade);
	
}
