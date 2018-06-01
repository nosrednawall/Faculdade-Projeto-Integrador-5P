package br.org.iel.recrutaif.model.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

/**
 * 
 * @author anderson
 *
 * @param <T>
 *            será a classe passada como argumento
 * @param entity
 *            entidade que será salva
 */

public abstract class BaseDao<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// construtor em branco
	public BaseDao() {
	}

	// Administrador de entidade
	protected abstract EntityManager getEntityManager();

	/**
	 * Método para salvar uma entidades
	 * 
	 * @param entity
	 */
	public void save(T entity) {
		try {
			getEntityManager().persist(entity);

		} catch (Exception e) {
			System.out.println("[INFO] objeto já existe ou possui parametros unicos no banco");
		}
	}

	/**
	 * Método para atualizar uma entidade
	 * 
	 * @param entity
	 * @return
	 */
	public T update(T entity) {
		return getEntityManager().merge(entity);
	}

	/**
	 * Método para remover uma entidade
	 * 
	 * @param entity
	 */
	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	/**
	 * Método para procurar uma entidade pelo id
	 * 
	 * @param type
	 * @param id
	 * @return
	 */
	public T find(Class<T> type, Object id) {
		return getEntityManager().find(type, id);
	}
}
