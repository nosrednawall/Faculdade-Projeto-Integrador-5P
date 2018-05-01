package br.org.iel.recrutaif.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	private TipoUsuario permissao;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<SystemRole> roles = new ArrayList<>();

	//para o hibernate
	@Deprecated
	public Usuario() {}
	
	//um usuario só pode ser criado com os campos abaixo
	public Usuario(String nome, String senha, Long matricula, Calendar dataAdmissao,
			TipoUsuario permissao, String email) {
		this.nome = nome;
		this.senha = senha;
		this.matricula = matricula;
		this.dataAdmissao = dataAdmissao;
		this.permissao = permissao;
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

	public TipoUsuario getPermissao() {
		return permissao;
	}

	public void setPermissao(TipoUsuario permissao) {
		this.permissao = permissao;
	}
}
