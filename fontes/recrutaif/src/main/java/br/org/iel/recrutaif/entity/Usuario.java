package br.org.iel.recrutaif.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String nome;
	private String senha;
	private Long matricula;
	
	private String email;

	@Temporal(TemporalType.DATE)
	private Calendar dataAdmissao;
	// private LocalDateTime dataAdmissao;

	@Enumerated
	private NivelPermissao permissao;

	//para o hibernate
	@Deprecated
	public Usuario() {}
	
	//um usuario só pode ser criado com os campos abaixo
	public Usuario(String nome, String senha, Long matricula, Calendar dataAdmissao,
			NivelPermissao permissao, String email) {
		this.nome = nome;
		this.senha = senha;
		this.matricula = matricula;
		this.dataAdmissao = dataAdmissao;
		this.permissao = permissao;
		this.email = email;
	}

	public Usuario(String email, String senha) {
		this.senha = senha;
		this.email = email;
	}
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getMatricula() {
		return matricula;
	}

	public NivelPermissao getPermissao() {
		return permissao;
	}

	public void setPermissao(NivelPermissao permissao) {
		this.permissao = permissao;
	}
}
