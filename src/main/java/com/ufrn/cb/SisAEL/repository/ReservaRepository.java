package com.ufrn.cb.SisAEL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ufrn.cb.SisAEL.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

	
}
