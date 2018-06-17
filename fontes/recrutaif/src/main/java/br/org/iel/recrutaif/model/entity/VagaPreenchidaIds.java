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
	private Integer usuarioId;
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Integer getVagaId() {
		return vagaId;
	}
	public void setVagaId(Integer vagaId) {
		this.vagaId = vagaId;
	}
	
}
