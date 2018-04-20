package br.org.iel.recrutaif.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.org.iel.recrutaif.model.Vaga;

@Stateless
public class VagaDao {

	@PersistenceContext(unitName = "recrutaif-persistence-unit")
	private EntityManager em;

	public void create(Vaga entity) {
		em.persist(entity);
	}

	public void deletaPorId(Long id) {
		Vaga entity = em.find(Vaga.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Vaga buscaPorId(Long id) {
		return em.find(Vaga.class, id);
	}

	public Vaga atualiza(Vaga entity) {
		return em.merge(entity);
	}

	public List<Vaga> listaTodos(Integer startPosition, Integer maxResult) {
		TypedQuery<Vaga> findAllQuery = em.createQuery("SELECT DISTINCT v FROM Vaga v ORDER BY v.id",
				Vaga.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
