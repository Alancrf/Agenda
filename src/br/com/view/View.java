package br.com.view;

import java.util.Scanner;

import br.com.dao.GenericDAO;
import br.com.entities.Contato;

public class View {

	public static void main(String[] args) {
		
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
	
}
