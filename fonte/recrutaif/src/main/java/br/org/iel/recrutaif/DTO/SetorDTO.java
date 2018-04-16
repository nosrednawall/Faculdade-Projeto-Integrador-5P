package br.org.iel.recrutaif.DTO;

import com.google.gson.Gson;

public class SetorDTO {
	
	private String nome;
	private String id;
	
	public String toGson() {
		return new Gson().toJson(this);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
