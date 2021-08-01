package com.ufrn.cb.SisAEL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ufrn.cb.SisAEL.entity.ItemEquipamento;

@Transactional
@Repository
public interface ItemEquipamentoRepository 
								extends JpaRepository<ItemEquipamento, Long> {

	@Transactional
	@Modifying
	@Query("select i from ItemEquipamento i where i.equipamento.id = :idTipoEquipamento")
	List<ItemEquipamento> listarPorTipoEquipamento(@Param("idTipoEquipamento") long idTipoEquipamento);
	
	
}
