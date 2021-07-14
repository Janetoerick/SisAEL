package com.ufrn.cb.SisAEL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.Equipamento;

@Transactional
public interface EquipRepository extends JpaRepository<Equipamento, Long> {
	List<Equipamento> findByidSala(Long idSala);
	List<Equipamento> findByNomeContains(String nome);
}
