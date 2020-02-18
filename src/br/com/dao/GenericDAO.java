package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jpautil.JpaUtil;

public class GenericDAO<E> {

	public void save(E entidade) {
		//Usando o JpaUtils que foi criado em br.com.jpautil
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		//Obtendo uma transação para o banco de dados (iniciando um processo para alguma operação (CRUD)
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		//Iniciando a transação (ativando)
		entityTransaction.begin();
		
		//Salvando no Banco de dados, (é preciso chamar o método persist e passando a entidade recebida por parâmetro)
		try {
			entityManager.persist(entidade);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entityTransaction.rollback();
		}
		
		//fazendo commit
		entityTransaction.commit();
		
		//fechando conexão
		entityManager.close();
	}
}
