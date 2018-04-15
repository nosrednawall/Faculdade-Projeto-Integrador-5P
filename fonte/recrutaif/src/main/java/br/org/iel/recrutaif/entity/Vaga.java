package br.org.iel.recrutaif.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Vaga {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String titulo;
	
	@NotNull
	private String descricao;

	@NotNull
	private String email;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Calendar dataCriacao;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Calendar dataExpiracao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusVaga status;
	
	@NotNull
	@ManyToOne
	private Setor setor;

	//implementações a serem estudadas
	public Vaga() {
	}

	public Vaga(String titulo, Integer id) {
		this.titulo = titulo;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	
	//getters and setters
	

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Calendar dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

}
