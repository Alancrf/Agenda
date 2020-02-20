package br.com.view;

import java.util.List;
import java.util.Scanner;
import br.com.entities.Contato;

public class ViewContato {

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

	public void preencheContato(Contato contato, ACAO acao) {

		Scanner scanner = new Scanner(System.in);

		if (acao == ACAO.EXCLUIR) {
			System.out.println("Digite o ID para " + acao.name().toLowerCase());
			long id = scanner.nextLong();
			contato.setId(id);

		}

		if (acao == ACAO.CADASTRAR) {

			System.out.println("Digite o Nome");
			String nome = scanner.nextLine();
			System.out.println("Digite o Endereço");
			String endereco = scanner.nextLine();
			System.out.println("Digite o Telefone");
			String telefone = scanner.nextLine();

			contato.setNome(nome);
			contato.setEndereco(endereco);
			contato.setTelefone(telefone);

			scanner.close();
		}

		if (acao == ACAO.ALTERAR) {

			System.out.println("Digite o ID para " + acao.name().toLowerCase());
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

			scanner.close();
		}

	}

	public void listar(List<Contato> contatos) {
		System.out.print("ID  Nome      Telefone    Endereco");
		System.out.println("");
		for (Contato contato : contatos) {
			System.out.println(contato.getId() + "  " + contato.getNome() + "  " + contato.getTelefone() + "  "
					+ (contato.getEndereco()));

		}

	}

}
