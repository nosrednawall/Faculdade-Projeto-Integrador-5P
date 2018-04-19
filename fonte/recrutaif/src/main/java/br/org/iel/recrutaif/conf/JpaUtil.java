package br.org.iel.recrutaif.conf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory manager = Persistence.createEntityManagerFactory("recrutaif_postgres"); 
	
	public EntityManager getEntityManager() {
		return manager.createEntityManager();
	}
}