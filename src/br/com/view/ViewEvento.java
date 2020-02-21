package br.com.view;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import br.com.entities.Contato;
import br.com.entities.Evento;

public class ViewEvento {

	public static enum ACAO {

		CADASTRAR, ALTERAR, EXCLUIR, LISTAR
	}

	public int optionMenu() {
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		
		System.out.println("Menu de Opções");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Alterar");
		System.out.println("3 - Excluir");
		System.out.println("4 - Listar");
		
		option = scanner.nextInt();

			switch (option) {

			case 1:
				option = 1;
				break;
			case 2:
				option = 2;
				break;
			case 3:
				option = 3;
				break;
			case 4:
				option = 4;
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}

		return option;
	}

	public void preencheEvento(Evento evento, ACAO acao) {

		Scanner scanner = new Scanner(System.in);

		if (acao == ACAO.EXCLUIR) {
			System.out.println("Digite o ID para " + acao.name().toLowerCase());
			long id = scanner.nextLong();
			evento.setIdEvento(id);

		}

		if (acao == ACAO.CADASTRAR) {

			Set<Contato> contatos = new HashSet<Contato>();
			Contato contato1 = new Contato();
			Contato contato2 = new Contato();
			
			System.out.println("Digite o Nome");
			String nomeEvento = scanner.nextLine();
			System.out.println("Digite o local do Evento");
			String local = scanner.nextLine();
			
			contato1.setId(8);
			contato2.setId(9);
			contatos.add(contato1);
			contatos.add(contato2);
			
			evento.setNomeEvento(nomeEvento);
			evento.setLocal(local);
			evento.setContatos(contatos);
			
			scanner.close();
		}

		if (acao == ACAO.ALTERAR) {
			Set<Contato> contatos = new HashSet<Contato>();
			Contato contato1 = new Contato();
			Contato contato2 = new Contato();
			
			System.out.println("Digite o ID para " + acao.name().toLowerCase());
			long id = scanner.nextLong();
			evento.setIdEvento(id);
			scanner.nextLine();
			System.out.println("Digite o Nome");
			String nomeEvento = scanner.nextLine();
			System.out.println("Digite o local do Evento");
			String local = scanner.nextLine();
			
			contato1.setId(8);
			contato2.setId(9);
			contatos.add(contato1);
			contatos.add(contato2);
			
			
			evento.setNomeEvento(nomeEvento);
			evento.setLocal(local);
			evento.setContatos(contatos);

			scanner.close();
		}

	}

	public void listar(List<Evento> eventos) {
		System.out.print("ID  Nome      Telefone    Endereco");
		System.out.println("");
		for (Evento evento : eventos) {
			System.out.println(evento.getIdEvento() + "  " + evento.getNomeEvento() + "  " + evento.getLocal() + "  "
					+ (evento.getContatos()));

		}

	}
	
}
