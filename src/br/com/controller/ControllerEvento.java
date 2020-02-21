package br.com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.text.View;
import br.com.dao.GenericDAO;
import br.com.entities.Evento;
import br.com.view.ViewEvento;
import br.com.view.ViewEvento.ACAO;

public class ControllerEvento {

	ViewEvento view = new ViewEvento();

	public static void main(String[] args) {
		ControllerEvento controllerEvento = new ControllerEvento();
		controllerEvento.inserir();
	}
	
	public void listar() {
		
		List<Evento> eventos = new ArrayList<Evento>();
		GenericDAO<Evento> genericDAO = new GenericDAO<Evento>();
		eventos = genericDAO.getListEntity(Evento.class);
		view.listar(eventos);
	}
	
	public void inserir () {
		Evento evento = new Evento();
		GenericDAO<Evento> daoGeneric = new GenericDAO<Evento>();
		view.preencheEvento(evento, ACAO.CADASTRAR);
		daoGeneric.save(evento);
	}
	
	public  void delete () {
		
		Evento evento = new Evento();
		GenericDAO<Evento> daoGeneric = new GenericDAO<Evento>();
		view.preencheEvento(evento, ACAO.EXCLUIR);
		daoGeneric.delete(evento, evento.getIdEvento());
		
	}
	
	public void update() {
		Evento evento = new Evento();
		view.preencheEvento(evento, ACAO.ALTERAR);
		GenericDAO<Evento> genericDAO = new GenericDAO<Evento>();
		genericDAO.update(evento);
		
	}
	
}
