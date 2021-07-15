package com.ufrn.cb.SisAEL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.Sala;

@Transactional
@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{
	
}
