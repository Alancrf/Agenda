package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
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
	
	public void update(E entidade) {
		
		//Usando o JpaUtils que foi criado em br.com.jpautil
		EntityManager entityManager = JpaUtil.getEntityManager();
				
		//Obtendo uma transação para o banco de dados (iniciando um processo para alguma operação (CRUD)
		EntityTransaction entityTransaction = entityManager.getTransaction();
				
		//Iniciando a transação (ativando)
		entityTransaction.begin();
				
		//Salvando no Banco de dados, (é preciso chamar o método persist e passando a entidade recebida por parâmetro)
		try {
			entityManager.merge(entidade);
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
	
	public List<E> getListEntity(Class<E> entidade){
	
		//Usando o JpaUtils que foi criado em br.com.jpautil
		EntityManager entityManager = JpaUtil.getEntityManager();
				
		//Obtendo uma transação para o banco de dados (iniciando um processo para alguma operação (CRUD)
		EntityTransaction entityTransaction = entityManager.getTransaction();
				
		//Iniciando a transação (ativando)
		entityTransaction.begin();
		
		@SuppressWarnings("unchecked")
		List<E> listaEntidade = entityManager.createQuery("from "+entidade.getName()).getResultList();
				
		//fazendo commit
		entityTransaction.commit();
				
		//fechando conexão
		entityManager.close();
		
		return listaEntidade;
	}
	
	@SuppressWarnings("unchecked")
	public void delete(E entidade, long id) {
		
	
		//Usando o JpaUtils que foi criado em br.com.jpautil
		EntityManager entityManager = JpaUtil.getEntityManager();
						
		//Obtendo uma transação para o banco de dados (iniciando um processo para alguma operação (CRUD)
		EntityTransaction entityTransaction = entityManager.getTransaction();
						
		//Iniciando a transação (ativando)
		entityTransaction.begin();
		
		entidade = (E) entityManager.find(entidade.getClass(), id);
		
		entityManager.remove(entidade);
		
		//fazendo commit
		entityTransaction.commit();
						
		//fechando conexão
		entityManager.close();
		
	}
}
