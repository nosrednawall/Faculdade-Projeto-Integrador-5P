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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import br.org.iel.recrutaif.model.enums.NivelPermissao;
import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;

/**
 * 
 * @author anderson
 *
 */
@NamedQueries({
		@NamedQuery(name = "Usuario.listarTodos", query = "SELECT DISTINCT u FROM Usuario u LEFT JOIN FETCH u.candidaturas WHERE u.status = :pStatus"),
		@NamedQuery(name = "Usuario.listarTodosSemStatus", query = "SELECT DISTINCT u FROM Usuario u LEFT JOIN FETCH u.candidaturas"),
		@NamedQuery(name = "Usuario.find", query = "SELECT DISTINCT u FROM Usuario u LEFT JOIN FETCH u.candidaturas WHERE u.id = :pId"),
		@NamedQuery(name = "Usuario.loga", query = "SELECT DISTINCT u FROM Usuario u  LEFT JOIN FETCH u.candidaturas WHERE u.email = :pEmail AND u.senha = :pSenha") })
@XmlRootElement
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8161894339545359421L;

	/**
	 * Atributos
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@NotNull
	@Size(min = 5, max = 250)
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String senha;

	@Column(unique = true, nullable = false)
	private String matricula;

	@Column(unique = true)
	private String email;

	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Enumerated(EnumType.STRING)
	private NivelPermissao permissao;

	@Enumerated(EnumType.STRING)
	private StatusBinarioEnum status;

	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<VagaPreenchida> candidaturas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public NivelPermissao getPermissao() {
		return permissao;
	}

	public void setPermissao(NivelPermissao permissao) {
		this.permissao = permissao;
	}

	public StatusBinarioEnum getStatus() {
		return status;
	}

	public void setStatus(StatusBinarioEnum status) {
		this.status = status;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
}