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

public class VagaValidator2 {
	
	static Vaga vaga;
	
	private boolean id;
	private boolean titulo;
	private boolean descricao;	
	private boolean setores;	
	private StatusVaga status;	
	private Calendar dataCriacao;	
	private Calendar dataExpiracao;
	
	

	private boolean validarId() {
		
		return id;
	}



	private boolean validarTitulo() {
		return titulo;
	}



	private boolean validarDescricao() {
		return descricao;
	}



	private boolean validarSetores() {
		return true;
	}



	private boolean validarStatus() {
		
		if (vaga.getStatus().equals(null)) return false;
		
		
		return true;
		
		
	}



	private boolean validarDataCriacao() {
		return true;
	}



	private boolean validarDataExpiracao() {
		return true;
	}



	public static boolean validar(Vaga vagaTeste) {
		vaga = vagaTeste;
		
		return false;
		
		
	}
}
