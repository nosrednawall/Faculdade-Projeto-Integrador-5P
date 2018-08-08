package br.org.iel.recrutaif.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.org.iel.recrutaif.model.entity.Credencial;
import br.org.iel.recrutaif.model.entity.Usuario;
import br.org.iel.recrutaif.model.enums.StatusBinarioEnum;

/**
 * 
 * @author anderson
 *
 */

@Stateless
public class UsuarioDao extends BaseDao<Usuario> implements Serializable {

	/**
	 * serial
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
		return this.em;
	}

	/**
	 * Método lista todos os usuarios com status e sem status
	 * 
	 * @param status
	 * @return
	 */
	public List<Usuario> listaTodos(StatusBinarioEnum status) {
		
		if(status.equals(StatusBinarioEnum.AMBOS)) {
			TypedQuery<Usuario> query = getEntityManager().createNamedQuery("Usuario.listarTodosSemStatus", Usuario.class);
			return query.getResultList();
		}
		TypedQuery<Usuario> query = getEntityManager().createNamedQuery("Usuario.listarTodos", Usuario.class);
		query.setParameter("pStatus", status);

		return query.getResultList();
	}

	/**
	 * Método busca usuario por id
	 * 
	 * @param id
	 * @return
	 */
	public Usuario find(Integer id) {

		TypedQuery<Usuario> query = getEntityManager().createNamedQuery("Usuario.find", Usuario.class);
		query.setParameter("pId", id);

		return query.getSingleResult();
	}

	/**
	 * Método loga, recebe as credenciais do usuario e confere a validade com o
	 * banco
	 * 
	 * @param credenciais
	 * @return
	 */
	public Usuario getBuscaPorEmail(Credencial credenciais) {

		TypedQuery<Usuario> query = getEntityManager().createNamedQuery("Usuario.loga", Usuario.class);

		query.setParameter("pEmail", credenciais.getEmail());
		query.setParameter("pSenha", credenciais.getSenha());

		try {
			
			return query.getSingleResult();

		} catch (Exception e) {
			System.out.println("[INFO] Usuário não existe no banco de dados");
		}
		
		return null;
	}
}
