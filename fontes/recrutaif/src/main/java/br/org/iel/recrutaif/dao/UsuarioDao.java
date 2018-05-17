package br.org.iel.recrutaif.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.org.iel.recrutaif.entity.Credencial;
import br.org.iel.recrutaif.entity.Usuario;

/**
 * 
 * @author anderson
 *
 */

@Stateless
public class UsuarioDao extends BaseDao<Usuario> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Unidade de persistencia
	 */
	@PersistenceContext(unitName = "recrutaif-persistence-unit")
	private EntityManager em;
	
	/**
	 * Método responsável por fornecer a sessão do entity manager
	 */
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return this.em;
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
	

    public List<Usuario> getBuscaPorEmail(Credencial credenciais) {

        String jpql = "select distinct avg(u.email) from Usuario u where u.email=:pEmail "
                + "and u.senha=:pSenha";

        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);

        query.setParameter("pEmail", credenciais.getEmail());
        query.setParameter("pSenha", credenciais.getSenha());

        return query.getResultList();

    }


	
}
