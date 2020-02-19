package br.com.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.dao.GenericDAO;
import br.com.entities.Contato;

public class View {

	public static void main(String[] args) {
	
		//inserir();
		//delete();
		//update();
		listar();	
	}
	
	public static void listar() {
		
		List<Contato> contatos = new ArrayList<Contato>();
		GenericDAO<Contato> genericDAO = new GenericDAO<Contato>();
		contatos = genericDAO.getListEntity(Contato.class);
		System.out.print("ID  Nome      Telefone    Endereco");
		System.out.println("");
		for (Contato contato : contatos) {
			
			System.out.println(contato.getId() + "  " + contato.getNome() + "  " + contato.getTelefone() + "  " + (contato.getEndereco()));
			//Rua C, Casa 20, Jardis Mangueiral     61983194067
		}
		
	}
	
	public static void inserir () {
		Contato contato = new Contato();
		GenericDAO<Contato> daoGeneric = new GenericDAO<Contato>();
		Scanner scanner =  new Scanner(System.in);
		
		System.out.println("Digite o Nome");
		String nome = scanner.nextLine();
		System.out.println("Digite o Endereço");
		String endereco = scanner.nextLine();
		System.out.println("Digite o Telefone");
		String telefone = scanner.nextLine();
		
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setTelefone(telefone);
		
		daoGeneric.save(contato);
		
		scanner.close();
	}
	
	public static void delete () {
		
		Contato contato = new Contato();
		GenericDAO<Contato> daoGeneric = new GenericDAO<Contato>();
		Scanner scanner =  new Scanner(System.in);
		
		
		System.out.println("Digite o ID para deletar");
		long id = scanner.nextLong();
		contato.setId(id);
		
		daoGeneric.delete(contato, contato.getId());
		scanner.close();
	}
	
	public static void update() {
		
		Contato contato = new Contato();
		GenericDAO<Contato> genericDAO = new GenericDAO<Contato>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID para fazer update");
		long id = scanner.nextLong();
		contato.setId(id);
		
		scanner.nextLine();
		System.out.println("Digite o Nome");
		String nome = scanner.nextLine();
		System.out.println("Digite o Endereço");
		String endereco = scanner.nextLine();
		System.out.println("Digite o Telefone");
		String telefone = scanner.nextLine();
		
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setTelefone(telefone);
		
		genericDAO.update(contato);
		scanner.close();
		
	}
		
}
