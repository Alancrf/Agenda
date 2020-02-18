package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jpautil.JpaUtil;

public class GenericDAO<E> {

	public void save(E entidade) {
		//Usando o JpaUtils que foi criado em br.com.jpautil
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		//Obtendo uma transa��o para o banco de dados (iniciando um processo para alguma opera��o (CRUD)
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		//Iniciando a transa��o (ativando)
		entityTransaction.begin();
		
		//Salvando no Banco de dados, (� preciso chamar o m�todo persist e passando a entidade recebida por par�metro)
		try {
			entityManager.persist(entidade);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entityTransaction.rollback();
		}
		
		//fazendo commit
		entityTransaction.commit();
		
		//fechando conex�o
		entityManager.close();
	}
}
