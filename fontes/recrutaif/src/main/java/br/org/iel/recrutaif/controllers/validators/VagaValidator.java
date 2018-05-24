package br.org.iel.recrutaif.controllers.validators;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.org.iel.recrutaif.model.entity.Setor;
import br.org.iel.recrutaif.model.entity.Vaga;
import br.org.iel.recrutaif.model.enums.StatusVaga;

public class VagaValidator {

	public static boolean validar(Vaga vagaTeste) {
//		vaga = vagaTeste;
//		
//		DataValidaIntervalo.valida(vagaTeste.getDataCriacao());
//		DataValidaDiasInvalidos.valida(vagaTeste.getDataCriacao());
//		DataValidaDiasFeriados.valida(vagaTeste.getDataCriacao());
		
		return false;
		
		
	}
}
