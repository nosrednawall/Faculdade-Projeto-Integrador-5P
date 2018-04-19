package br.org.iel.recrutaif.dao;

/*
 * Verificar como utilizar essa classe sem o stateless
 * 
 * */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.org.iel.recrutaif.entity.Setor;

public class SetorDao {

	@PersistenceContext
	private EntityManager manager;

	public SetorDao(EntityManager manager) {
		this.manager = manager;
	}

	/* Método para salvar um setor */
	public void adiciona(Setor setor) {
		
		System.out.println("[INFO] Salvou o Setor " + setor.getNome());
		
		manager.persist(setor);
	}

	/* Método para listar os setores gravados no banco */
	public List<Setor> listaSetores() {
		
		System.out.println("[INFO] Está Listando os Setores");

		
		return manager.createQuery("select s from Setor s", Setor.class).getResultList();
	}

	public Setor buscaSetor(Integer id) {
		Setor setor = manager.find(Setor.class, id);
		
		System.out.println("[INFO] Buscou o Setor " + setor.getNome());
		
		return setor;
	}

	public void deletaSetor(Integer id) {
		Setor setor = manager.find(Setor.class, id);
		
		System.out.println("[INFO] Deletou o Setor " + setor.getNome());

		manager.remove(setor);
	}
	
	public void alteraSetor(Setor setor) {
		
		manager.persist(setor);
		
		System.out.println("[INFO] Alterou o Setor " + setor.getNome());

	}
}
