package br.org.iel.recrutaif.dao;

/*
 * Verificar como utilizar essa classe sem o stateless
 * 
 * */

import java.util.List;

//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.org.iel.recrutaif.entity.Setor;

//@Stateless
public class SetorDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	/* Método para salvar um setor */
	public void salva(Setor setor) {
		manager.persist(setor);
	}
	/* Método para listar os setores gravados no banco */
	public List<Setor> todosSetores(){
		return manager.createQuery("select s from Setor",Setor.class).getResultList();
	}
}
