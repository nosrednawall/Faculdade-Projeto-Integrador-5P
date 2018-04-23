package br.org.iel.recrutaif.model;

import java.io.Serializable;

//imports
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

//anotações
@Entity // essa anotação indica ao JPA/Hibernate que esta classe é uma entidade, ou seja
		// uma tabela
@Table(name = "setor") // indica que o nome da tabela a ser criada
@XmlRootElement // indica ao Jersey que essa classe deve ser utilizada para efetuar o parse de
				// objetos a serem enviados ou recebidos via http

public class Setor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id // indica que esse atributo deve ser o primary key da tabela
	@GeneratedValue(strategy = GenerationType.AUTO) // indica que a estratégia de valores 
													//a serem gerados é a padrão do banco
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String nome;

	// getters and setters

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Setor)) {
			return false;
		}
		Setor other = (Setor) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		// result += ", version: " + version;
		if (nome != null && !nome.trim().isEmpty())
			result += ", nome: " + nome;
		return result;
	}
}