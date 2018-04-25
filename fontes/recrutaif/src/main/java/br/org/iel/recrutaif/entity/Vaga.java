package br.org.iel.recrutaif.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Vaga
 *
 */
@Entity
@Table(name = "vaga")
@XmlRootElement
public class Vaga implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String titulo;
	
	@Lob	//permite essa coluna possuir grande volume de dados
	private String descricao;

	@ManyToMany(fetch=FetchType.EAGER)
	private List<Setor> setores;

	@Enumerated
	private StatusVaga status;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataCriacao;

	@Temporal(TemporalType.DATE)
	private Calendar dataExpiracao;


	public Vaga() {
	}

	public Vaga(String titulo, String descricao, List<Setor> setores, Calendar dataCriacao, Calendar dataExpiracao,
			StatusVaga status) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.setores = setores;
		this.dataCriacao = dataCriacao;
		this.dataExpiracao = dataExpiracao;
		this.status = status;
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


	public List<Setor> getSetores() {
		return setores;
	}


	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}

	public Calendar getDataExpiracao() {
		return dataExpiracao;
	}


	public void setDataExpiracao(Calendar dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}


	public StatusVaga getStatus() {
		return status;
	}


	public void setStatus(StatusVaga status) {
		this.status = status;
	}


	public Long getId() {
		return id;
	}


	public Calendar getDataCriacao() {
		return dataCriacao;
	}

}
