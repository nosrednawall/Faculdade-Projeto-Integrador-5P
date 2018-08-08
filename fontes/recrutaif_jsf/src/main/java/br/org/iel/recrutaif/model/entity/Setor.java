package br.org.iel.recrutaif.model.entity;

import java.io.Serializable;

//imports
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;

/**
 * 
 * @author anderson
 *
 */

@NamedQueries({
	@NamedQuery(name = "Setor.find", query = "SELECT DISTINCT s FROM Setor s WHERE s.id = :pId"),
		@NamedQuery(name = "Setor.listarTodos", query = "SELECT DISTINCT s FROM Setor s WHERE s.status = :pStatus"),
		@NamedQuery(name = "Setor.listarTodosSemStatus", query = "SELECT DISTINCT s FROM Setor s") })

@Entity
@Table(name = "setor")
@XmlRootElement
public class Setor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "status")
	private StatusBinarioEnum status;

	@Override
	public String toString() {
		return "Setor [id=" + id + ", nome=" + nome + ", status=" + status + "]";
	}

	public StatusBinarioEnum getStatus() {
		return status;
	}

	public void setStatus(StatusBinarioEnum status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}