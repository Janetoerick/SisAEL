package com.ufrn.cb.SisAEL.service;

import com.ufrn.cb.SisAEL.entity.Equipamento;
import com.ufrn.cb.SisAEL.entity.Laboratorio;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.Sala;

public class ProdutoValidatorImpl extends ProdutoValidator{

	public boolean validar(Produto produto) {
		try {
			Equipamento e = (Equipamento) produto;
			
			if(e.getTombamento() != null) {
				EquipamentoValide ev = new EquipamentoValide();
				return ev.validar(produto);
			}
		} catch(Exception ex) {
			try {
				Laboratorio l = (Laboratorio) produto;
				if(l.getSalas() != null) {
					LaboratorioValide lv = new LaboratorioValide();
					return lv.validar(produto);
				}
				
			} catch(Exception ex1) {
				try {
					Sala s = (Sala) produto;
					SalaValide sv = new SalaValide();
					return sv.validar(produto);
				} catch(Exception ex2) {
					return false;
				}
				
			}
		}
		return false;
	}
}
