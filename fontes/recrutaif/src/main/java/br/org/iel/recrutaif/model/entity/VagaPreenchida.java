package br.org.iel.recrutaif.model.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="vaga_preenchida")
@XmlRootElement
public class VagaPreenchida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataInscricao;
	
	@ManyToOne
	 @JoinColumn(name = "vaga_id")
	private Vaga vaga;
	
	@ManyToOne
	 @JoinColumn(name = "candidato_id")
	private Usuario candidato;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Calendar dataInscricao) {
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
