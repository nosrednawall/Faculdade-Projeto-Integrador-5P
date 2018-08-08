package br.org.iel.recrutaif.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.org.iel.recrutaif.model.entity.Setor;
import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;

/**
 * 
 * @author anderson
 *
 */
@Stateless
public class SetorDao extends BaseDao<Setor> implements Serializable {
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
	 * metodo busca setor
	 * 
	 * @param id
	 * @return
	 */
	public Setor find(Integer id) {

		TypedQuery<Setor> query = getEntityManager().createNamedQuery("Setor.find", Setor.class);
		query.setParameter("pId", id);

		return query.getSingleResult();
	}

	/**
	 * Metodo lista setores com ou sem status
	 * 
	 * @param status
	 * @return
	 */
	public List<Setor> listaTodos(StatusBinarioEnum status) {

		if (status.equals(StatusBinarioEnum.AMBOS)) {
			TypedQuery<Setor> query = getEntityManager().createNamedQuery("Setor.listarTodosSemStatus", Setor.class);
			return query.getResultList();
		}
		TypedQuery<Setor> query = getEntityManager().createNamedQuery("Setor.listarTodos", Setor.class);
		query.setParameter("pStatus", status);

		return query.getResultList();
	}

}