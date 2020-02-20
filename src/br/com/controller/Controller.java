package br.com.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.dao.GenericDAO;
import br.com.entities.Contato;
import br.com.view.ViewContato;
import br.com.view.ViewContato.ACAO;

public class Controller {
	
	ViewContato view = new ViewContato();
	
	public static void main(String[] args) {
		
		Controller controller = new Controller();
		ViewContato view = new ViewContato();
		int opcao = view.optionMenu();
		
		if(opcao == 1) {
			controller.inserir();
		}else if(opcao == 2) {
			controller.update();
		}else if(opcao == 3) {
			controller.delete();
		}else if (opcao == 4){
			controller.listar();
		}

	}
	
	public void listar() {
		
		List<Contato> contatos = new ArrayList<Contato>();
		GenericDAO<Contato> genericDAO = new GenericDAO<Contato>();
		contatos = genericDAO.getListEntity(Contato.class);
		view.listar(contatos);
	}
	
	public void inserir () {
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
