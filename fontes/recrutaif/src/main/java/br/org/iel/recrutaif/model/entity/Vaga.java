package br.org.iel.recrutaif.model.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.org.iel.recrutaif.model.enums.StatusVaga;

/**
 * 
 * @author anderson
 *
 */

@NamedQueries({ 

	@NamedQuery(
			name = "Vaga.listarTodos", 
			query = "SELECT DISTINCT v FROM Vaga v LEFT JOIN FETCH v.setores WHERE v.status = :pStatus"),
	@NamedQuery(
			name = "Vaga.find", 
			query = "SELECT DISTINCT v FROM Vaga v LEFT JOIN FETCH v.setores WHERE v.id = :pId")
})
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

	@Column(name = "titulo", length = 2, nullable = false) // copiado do Everton by Anderson
	private String titulo;

	@Lob // permite essa coluna possuir grande volume de dados
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY)
//	@Fetch(FetchMode.SUBSELECT)
	@JoinTable( name = "vaga_setor", joinColumns = @JoinColumn(name="vaga_id"), inverseJoinColumns = @JoinColumn(name="setor_id") )
	private Set<Setor> setores;

	@Enumerated(EnumType.STRING)
	private StatusVaga status;

	@Temporal(TemporalType.DATE)
	private Calendar dataCriacao;

	@Temporal(TemporalType.DATE)
	private Calendar dataExpiracao;

	/**
	 * Construtores e métodos
	 */

	//para o hibernate
	public Vaga() {}

	// constrututor seguro, porém ainda não implementado
	// public Vaga(String titulo, String descricao, List<Setor> setores, Calendar
	// dataCriacao, Calendar dataExpiracao,
	// StatusVaga status) {
	// this.titulo = titulo;
	// this.descricao = descricao;
	// this.setores = setores;
	// this.dataCriacao = dataCriacao;
	// this.dataExpiracao = dataExpiracao;
	// this.status = status;
	// }

	@Override
	public String toString() {
		return "Vaga [titulo=" + titulo + ", descricao=" + descricao + ", setores=" + setores + ", status=" + status
				+ ", dataCriacao=" + dataCriacao + ", dataExpiracao=" + dataExpiracao + "]";
	}

	/**
	 * Getters and Setters
	 * 
	 */

	public String getTitulo() {
		return titulo;
	}

	// Inserido limitador de coluna - Everton
	@Column(name = "titulo", length = 10, nullable = false)
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public Set<Setor> getSetores() {
		return setores;
	}

	public void setSetores(Set<Setor> setores) {
		this.setores = setores;
	}

}
