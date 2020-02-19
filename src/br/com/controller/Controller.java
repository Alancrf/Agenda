package br.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.dao.GenericDAO;
import br.com.entities.Contato;
import br.com.view.View;
import br.com.view.View.ACAO;

public class Controller {
	
	View view = new View();
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		//controller.listar();
		//controller.inserir();
		//controller.delete();
		controller.update();
		
	}
	
	public void listar() {
		
		List<Contato> contatos = new ArrayList<Contato>();
		GenericDAO<Contato> genericDAO = new GenericDAO<Contato>();
		contatos = genericDAO.getListEntity(Contato.class);
		view.listar(contatos);
	}
	
	public  void inserir () {
		Contato contato = new Contato();
		GenericDAO<Contato> daoGeneric = new GenericDAO<Contato>();
		view.preencheContato(contato, ACAO.CADASTRAR);
		daoGeneric.save(contato);
	}
	
	public  void delete () {
		
		Contato contato = new Contato();
		GenericDAO<Contato> daoGeneric = new GenericDAO<Contato>();
		view.preencheContato(contato, ACAO.EXCLUIR);
		daoGeneric.delete(contato, contato.getId());
		
	}
	
	public void update() {
		Contato contato = new Contato();
		view.preencheContato(contato, ACAO.ALTERAR);
		GenericDAO<Contato> genericDAO = new GenericDAO<Contato>();
		genericDAO.update(contato);
		
	}

}
