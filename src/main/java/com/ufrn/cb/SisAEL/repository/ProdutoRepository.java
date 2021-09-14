package com.ufrn.cb.SisAEL.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("select p from Produto p where p.estoque.id = :idEstoque")
	public List<Produto> listarPorEstoque(@Param(value="idEstoque")long idEstoque);
	
	@Transactional
	@Modifying
	@Query("update Produto p set p.disponivel =:disponivel where p.id = :id")
	public void atualizarDisponibilidadeProduto(@Param(value="id") long id,  @Param (value="disponivel") boolean disponivel);
}