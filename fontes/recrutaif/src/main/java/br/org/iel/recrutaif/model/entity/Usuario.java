package br.org.iel.recrutaif.model.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.org.iel.recrutaif.model.enums.NivelPermissao;
import br.org.iel.recrutaif.model.enums.StatusUsuario;

/**
 * 
 * @author anderson
 *
 */
@NamedQueries({
		@NamedQuery(name = "Usuario.listarTodos", query = "SELECT DISTINCT u FROM Usuario u WHERE u.status = :pStatus"),
		@NamedQuery(name = "Usuario.find", query = "SELECT DISTINCT u FROM Usuario u WHERE u.id = :pId"),
		@NamedQuery(name = "Usuario.loga", query = "SELECT DISTINCT u FROM Usuario u WHERE u.email = :pEmail AND u.senha = :pSenha") })
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

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String senha;

	@Column(unique = true, nullable = false)
	private String matricula;

	@Column(unique = true)
	private String email;

	@Temporal(TemporalType.DATE)
	private Calendar dataAdmissao;

	@Enumerated(EnumType.STRING)
	private NivelPermissao permissao;

	@Enumerated(EnumType.STRING)
	private StatusUsuario status;

	/**
	 * Contrutores e metodos
	 */

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", matricula=" + matricula + ", email=" + email + ", dataAdmissao="
				+ dataAdmissao + "]";
	}

	/**
	 * Getters and Setters
	 * 
	 */

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

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public NivelPermissao getPermissao() {
		return permissao;
	}

	public void setPermissao(NivelPermissao permissao) {
		this.permissao = permissao;
	}

	public StatusUsuario getStatus() {
		return status;
	}

	public void setStatus(StatusUsuario status) {
		this.status = status;
	}
}
