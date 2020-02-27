package br.com.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.GenericDAO;
import br.com.entities.Contato;

@ViewScoped
@ManagedBean(name = "beanContato")
public class BeanContato {

	private Contato contato = new Contato();
	private GenericDAO<Contato> genericDAO = new GenericDAO<Contato>();
	private List<Contato> contatos = new ArrayList<Contato>();
	
	
	
	public GenericDAO<Contato> getGenericDAO() {
		return genericDAO;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public String salvar () {
		
		genericDAO.save(contato);
		
		return "";
	}
	
	//chama o metodo toda a vez que a classe for instanciada 
	@PostConstruct
	public void load() {
		contatos = genericDAO.getListEntity(Contato.class);
	}
	

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
