package br.org.iel.recrutaif.dao;

import javax.persistence.EntityManager;

/**
 * 
 * @author anderson
 *
 * @param <T> será a classe passada como argumento
 */

public abstract class BaseDao<T> {

	//construtor em branco
    public BaseDao() {}

    //Administrador de entidade
    protected abstract EntityManager getEntityManager();

    public void save(T entity) {
        getEntityManager().persist(entity);
    }

    public T update(T entity) {
        return getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Class<T> type, Object id) {
        return getEntityManager().find(type, id);
    }
}
