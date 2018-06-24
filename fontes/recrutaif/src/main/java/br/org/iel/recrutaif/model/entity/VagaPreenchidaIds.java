package br.org.iel.recrutaif.model.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VagaPreenchidaIds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer vagaId;
	private Integer candidatoId;

	@Override
	public String toString() {
		return "VagaPreenchidaIds [vagaId=" + vagaId + ", candidatoId=" + candidatoId + "]";
	}

	public Integer getVagaId() {
		return vagaId;
	}

	public void setVagaId(Integer vagaId) {
		this.vagaId = vagaId;
	}

	public Integer getCandidatoId() {
		return candidatoId;
	}

	public void setCandidatoId(Integer candidatoId) {
		this.candidatoId = candidatoId;
	}

}
