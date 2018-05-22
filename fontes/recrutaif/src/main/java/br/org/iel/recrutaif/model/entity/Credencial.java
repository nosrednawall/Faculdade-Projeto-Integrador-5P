package br.org.iel.recrutaif.model.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Credencial {

	private String email;
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
