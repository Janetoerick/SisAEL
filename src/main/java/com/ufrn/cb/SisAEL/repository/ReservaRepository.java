package com.ufrn.cb.SisAEL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.Reserva;

@Transactional
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
