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

	@Temporal(TemporalType.DATE)
	private Calendar dataAdmissao;
	// private LocalDateTime dataAdmissao;

	@Enumerated
	private TipoUsuario permissao;

	//para o hibernate
	public Usuario() {}
	
	//um usuario só pode ser criado com os campos abaixo
	public Usuario(String nome, String senha, Long matricula, Calendar dataAdmissao, TipoUsuario permissao) {
		this.nome = nome;
		this.senha = senha;
		this.matricula = matricula;
		this.dataAdmissao = dataAdmissao;
		this.permissao = permissao;
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

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
}