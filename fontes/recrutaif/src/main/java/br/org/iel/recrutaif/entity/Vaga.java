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
import javax.persistence.Lob;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String titulo;
	
	@Lob	//permite essa coluna possuir grande volume de dados
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

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the setores
	 */
	public List<Setor> getSetores() {
		return setores;
	}

	/**
	 * @param setores
	 *            the setores to set
	 */
	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}

	/**
	 * @return the dataExpiracao
	 */
	public Calendar getDataExpiracao() {
		return dataExpiracao;
	}

	/**
	 * @param dataExpiracao
	 *            the dataExpiracao to set
	 */
	public void setDataExpiracao(Calendar dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	/**
	 * @return the status
	 */
	public StatusVaga getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(StatusVaga status) {
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the dataCriacao
	 */
	public Calendar getDataCriacao() {
		return dataCriacao;
	}

}
