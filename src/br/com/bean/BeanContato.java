package br.com.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.GenericDAO;
import br.com.entities.Contato;

@ViewScoped
@ManagedBean(name = "beanContato")
public class BeanContato {

	private Contato contato = new Contato();
	private GenericDAO<Contato> genericDAO = new GenericDAO<Contato>();
	
	public String salvar () {
		genericDAO.save(contato);
		
		return "";
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
