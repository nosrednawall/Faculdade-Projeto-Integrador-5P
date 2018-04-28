package br.org.iel.recrutaif.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SystemRole {

	@Id
	private String nome;
	
	@Deprecated
	public SystemRole() {
	}
	
	public SystemRole(String nome) {
		this.nome  = nome;
	}

	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
