package com.ufrn.cb.SisAEL.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufrn.cb.SisAEL.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("select p from Produto p where p.estoque.id = :idEstoque")
	public List<Produto> listarPorEstoque(@Param(value="idEstoque")long idEstoque);
}