package br.org.iel.recrutaif.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.org.iel.recrutaif.entity.Usuario;

@Stateless
public class UsuarioDao {
	
	@PersistenceContext(unitName = "recrutaif-persistence-unit")
	private EntityManager em;
	
	public void create(Usuario entity) {
		em.persist(entity);
	}
	
	public void deletaPorId(Long id) {
		Usuario entity = em.find(Usuario.class, id);
		if(entity != null) {
			em.remove(entity);
		}
	}
	
	public Usuario buscaPorId(Long id) {
		return em.find(Usuario.class, id);
	}
	
	public Usuario atualiza(Usuario entity) {
		return em.merge(entity);
	}
	
	public List<Usuario> listaTodos(Integer startPosition, Integer maxResult){
		TypedQuery<Usuario> findAllQuery = em.createQuery(
				"SELECT DISTINCT u FROM Usuario u ORDER BY u.id", Usuario.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
	

	
	
}
