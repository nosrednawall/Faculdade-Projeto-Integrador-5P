package br.org.iel.recrutaif.controllers.validators;

import java.util.Calendar;

import br.org.iel.recrutaif.model.entity.Vaga;
import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;

public class VagaValidator extends Vaga{
	
	static Vaga vaga;
	
	private boolean id;
	private boolean titulo;
	private boolean descricao;	
	private boolean setores;	
	private StatusBinarioEnum status;	
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



	public static boolean valida(Vaga LimiteDeCaracterNoCampo) {
		vaga = LimiteDeCaracterNoCampo;
		
		return false;
		
		
	}
}

