package br.org.iel.recrutaif.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;

/**
 * 
 * @author anderson
 *
 */

@NamedQueries({

		@NamedQuery(name = "Vaga.listarTodos", query = "SELECT DISTINCT v FROM Vaga v LEFT JOIN FETCH v.setor LEFT JOIN FETCH v.inscritos WHERE v.status = :pStatus"),
		@NamedQuery(name = "Vaga.listarTodosSemStatus", query = "SELECT DISTINCT v FROM Vaga v LEFT JOIN FETCH v.setor LEFT JOIN FETCH v.inscritos"),
		@NamedQuery(name = "Vaga.find", query = "SELECT DISTINCT v FROM Vaga v LEFT JOIN FETCH v.setor LEFT JOIN FETCH v.inscritos WHERE v.id = :pId") })
@Entity
@Table(name = "vaga")
@XmlRootElement
public class Vaga implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Atributos
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "titulo", nullable = false)
	private String titulo;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Enumerated(EnumType.STRING)
	private StatusBinarioEnum status;

	@Temporal(TemporalType.DATE)
	private Date dataCriacao;

	@Temporal(TemporalType.DATE)
	private Date dataExpiracao;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Setor setor;

	@ManyToMany()
	private Set<VagaPreenchida> inscritos;
//	
//	@OneToMany(mappedBy = "vaga", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<VagaPreenchida> inscritos;

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Vaga [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", status=" + status
				+ ", dataCriacao=" + dataCriacao + ", dataExpiracao=" + dataExpiracao + ", setor=" + setor
				+ ", inscritos=" + inscritos +"]";
	}

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

	public StatusBinarioEnum getStatus() {
		return status;
	}

	public void setStatus(StatusBinarioEnum status) {
		this.status = status;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Set<VagaPreenchida> getInscritos() {
		return inscritos;
	}

	public void setInscritos(Set<VagaPreenchida> inscritos) {
		this.inscritos = inscritos;
	}
	@Deprecated
	public Vaga() {}

	public Vaga(String titulo, String descricao, StatusBinarioEnum status, Date dataCriacao, Date dataExpiracao,
			Setor setor) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
		this.dataCriacao = dataCriacao;
		this.dataExpiracao = dataExpiracao;
		this.setor = setor;
	}
}
