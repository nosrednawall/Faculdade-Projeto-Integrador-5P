package br.org.iel.recrutaif.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	private String titulo;
	private String descricao;
	
	@OneToMany
	private List<Setor> setores;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataCriacao;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataExpiracao;
	
	@Enumerated
	private StatusVaga status;
	
	@Override
	public String toString() {
		return "Vaga [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", setores=" + setores
				+ ", dataCriacao=" + dataCriacao + ", dataExpiracao=" + dataExpiracao + ", status=" + status + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
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

	public StatusVaga getStatus() {
		return status;
	}

	public void setStatus(StatusVaga status) {
		this.status = status;
	}
}
