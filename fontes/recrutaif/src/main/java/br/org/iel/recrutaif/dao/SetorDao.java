package br.org.iel.recrutaif.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.org.iel.recrutaif.entity.Setor;

@Stateless
public class SetorDao {
	
	@PersistenceContext(unitName = "recrutaif-persistence-unit")
	private EntityManager em;

	public void create(Setor entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Setor entity = em.find(Setor.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Setor findById(Long id) {
		return em.find(Setor.class, id);
	}

	public Setor update(Setor entity) {
		return em.merge(entity);
	}

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

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}