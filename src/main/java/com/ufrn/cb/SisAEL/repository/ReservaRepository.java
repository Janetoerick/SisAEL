package com.ufrn.cb.SisAEL.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.Reserva;

@Transactional
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
	
	@Transactional
	@Query(value = "select r from Reserva r where r.laboratorio.id = :idLab "
			+ "and r.sala.id = :idSala and r.data = :data"
			+ " and r.horarioDaReserva.id = :idHorario")
	public  Optional<Reserva> obter(long idLab,
								long idSala, LocalDate data, long idHorario);

}
