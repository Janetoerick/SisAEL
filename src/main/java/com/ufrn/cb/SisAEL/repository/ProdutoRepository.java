package com.ufrn.cb.SisAEL.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufrn.cb.SisAEL.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}