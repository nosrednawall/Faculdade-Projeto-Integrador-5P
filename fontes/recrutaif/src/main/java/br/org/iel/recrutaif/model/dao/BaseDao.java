package br.org.iel.recrutaif.model.dao;

import javax.persistence.EntityManager;

/**
 * 
 * @author anderson
 *
 * @param <T> será a classe passada como argumento
 * @param entity entidade que será salva
 */

public abstract class BaseDao<T> {

	//construtor em branco
    public BaseDao() {}

    //Administrador de entidade
    protected abstract EntityManager getEntityManager();

    /**
     * Método para salvar uma entidades
     * @param entity
     */
    public void save(T entity) {
        getEntityManager().persist(entity);
    }

    /**
     * Método para atualizar uma entidade
     * @param entity
     * @return
     */
    public T update(T entity) {
        return getEntityManager().merge(entity);
    }

    /**
     * Método para remover uma entidade
     * @param entity
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Método para procurar uma entidade pelo id
     * @param type
     * @param id
     * @return
     */
    public T find(Class<T> type, Object id) {
        return getEntityManager().find(type, id);
    }
}
