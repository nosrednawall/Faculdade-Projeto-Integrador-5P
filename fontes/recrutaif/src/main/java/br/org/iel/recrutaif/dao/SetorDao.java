package br.org.iel.recrutaif.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.org.iel.recrutaif.entity.Setor;
/**
 * 
 * @author anderson
 *
 */
@Stateless
public class SetorDao extends BaseDao<Setor> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Unidade de persistencia, fornecida pelo wildfly
	 */
	@PersistenceContext(unitName = "recrutaif-persistence-unit")
	private EntityManager em;

	/**
	 * Método responsável por fornecer a sessão do entity manager
	 */
	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	/**
	 * Método listar os setores, conforme os indices fornecidos, se não fornecer listará todos os setores
	 * @param startPosition
	 * @param maxResult
	 * @return
	 */
	public List<Setor> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Setor> findAllQuery = em.createQuery("SELECT DISTINCT s FROM Setor s ORDER BY s.id", Setor.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}