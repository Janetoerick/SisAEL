package com.ufrn.cb.SisAEL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.HorarioDaReserva;

@Repository
@Transactional
public interface HorariosDaReservaRepository extends JpaRepository<HorarioDaReserva, Long> {

}
