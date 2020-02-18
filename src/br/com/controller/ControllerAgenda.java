package br.com.controller;

import br.com.dao.GenericDAO;
import br.com.entities.Contato;

public class ControllerAgenda {

	//Estanciando a entidade
	private Contato contato = new Contato();
	//Estanciando a Dao Generica
	private GenericDAO<Contato> daoGeneric = new GenericDAO<Contato>();
	
}
