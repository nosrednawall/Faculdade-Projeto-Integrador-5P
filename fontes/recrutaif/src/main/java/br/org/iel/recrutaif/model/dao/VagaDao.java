package br.org.iel.recrutaif.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.org.iel.recrutaif.model.entity.Vaga;
import br.org.iel.recrutaif.model.enums.StatusVaga;

@Stateless
public class VagaDao extends BaseDao<Vaga> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Entity manager e getEntitymanager
	 */
	
	@PersistenceContext(unitName = "recrutaif-persistence-unit")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	/**
	 * Método para listar vagas pelo status
	 * @param status
	 * @return
	 */
	public List<Vaga> listaTodos(StatusVaga status) {
		TypedQuery<Vaga> query = getEntityManager().createNamedQuery(
				"Vaga.listarTodos", Vaga.class);
		
		query.setParameter("pStatus", status);

		return query.getResultList();
	}
	
	/**
	 * Método para procurar vaga pelo ID
	 * @param id
	 * @return
	 */
	public Vaga find(Integer id) {
		
		TypedQuery<Vaga> query = getEntityManager().createNamedQuery(
				"Vaga.find", Vaga.class);
		query.setParameter("pId", id);
		
		return query.getSingleResult();
	}

}
