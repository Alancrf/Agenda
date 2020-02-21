package br.com.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEvento;
	private String nomeEvento;
	private String local;
	@ManyToMany
	@JoinTable(name = "Evento_Contato",
	joinColumns = @JoinColumn(name = "idEvento"),
	inverseJoinColumns = @JoinColumn(name = "idContato"))
	private Set<Contato> contatos;
	
	public Evento() {
		
	}

	public long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Set<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEvento ^ (idEvento >>> 32));
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((nomeEvento == null) ? 0 : nomeEvento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (idEvento != other.idEvento)
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (nomeEvento == null) {
			if (other.nomeEvento != null)
				return false;
		} else if (!nomeEvento.equals(other.nomeEvento))
			return false;
		return true;
	}
	
	
	
}
