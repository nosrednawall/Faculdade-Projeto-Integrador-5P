package br.org.iel.recrutaif.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({

	@NamedQuery(name = "VagaPreenchida.listarTodos", query = "SELECT DISTINCT v FROM VagaPreenchida v LEFT JOIN FETCH v.vaga LEFT JOIN FETCH v.candidato WHERE v.vaga.id = :pIdvaga AND v.candidato.id = :pIdusuario"),
	@NamedQuery(name = "VagaPreenchida.find", query = "SELECT DISTINCT v FROM VagaPreenchida v LEFT JOIN FETCH v.vaga LEFT JOIN FETCH v.candidato WHERE v.id = :pId") })

@Entity
@Table(name="vaga_preenchida")
@XmlRootElement
public class VagaPreenchida implements Serializable{

	/**
	 * serial
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date dataInscricao;
	
	@ManyToOne
	 @JoinColumn(name = "vaga_id")
	private Vaga vaga;
	
	@ManyToOne
	 @JoinColumn(name = "candidato_id")
	private Usuario candidato;
	
	public VagaPreenchida() {}
	
	public VagaPreenchida(Date dataInscricao, Vaga vaga, Usuario candidato) {
		this.dataInscricao = dataInscricao;
		this.vaga = vaga;
		this.candidato = candidato;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Usuario getCandidato() {
		return candidato;
	}

	public void setCandidato(Usuario candidato) {
		this.candidato = candidato;
	}

}
