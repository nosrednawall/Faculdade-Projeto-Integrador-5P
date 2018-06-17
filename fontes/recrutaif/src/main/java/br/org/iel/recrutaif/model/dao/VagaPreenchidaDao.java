package br.org.iel.recrutaif.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.org.iel.recrutaif.model.entity.VagaPreenchida;
import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;

@Stateless
public class VagaPreenchidaDao extends BaseDao<VagaPreenchida> implements Serializable{

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
	 * Método para listar VagaPreenchidas pelo status
	 * @param status
	 * @return
	 */
	public List<VagaPreenchida> listaTodos(StatusBinarioEnum status) {
		TypedQuery<VagaPreenchida> query = getEntityManager().createNamedQuery(
				"VagaPreenchida.listarTodos", VagaPreenchida.class);
		
		query.setParameter("pStatus", status);

		return query.getResultList();
	}
	
	/**
	 * Método para procurar VagaPreenchida pelo ID
	 * @param id
	 * @return
	 */
	public VagaPreenchida find(Integer id) {
		
		TypedQuery<VagaPreenchida> query = getEntityManager().createNamedQuery(
				"VagaPreenchida.find", VagaPreenchida.class);
		query.setParameter("pId", id);
		
		return query.getSingleResult();
	}

}
