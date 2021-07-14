package com.ufrn.cb.SisAEL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.Sala;

@Transactional
public interface SalaRepository extends JpaRepository<Sala, Long>{
	List<Sala> findByidLab(Long idlab);
}
