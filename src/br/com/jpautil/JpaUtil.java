package br.com.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	
	private static EntityManagerFactory factory = null;
	//tem que ser estático por que só pode ser executado uma única vez!!!!!
	static {
	
		if(factory == null) {
		factory = Persistence.createEntityManagerFactory("Agenda");
		}
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
}
