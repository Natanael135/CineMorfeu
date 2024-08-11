package CinemaMorfeu;

import java.util.ArrayList;
import java.util.Scanner;

public class IniciarCineMorfeu {

	public void Iniciar() {
		Scanner ler = new Scanner(System.in);

		CineMorfeu cinema = new CineMorfeu();

		// cria��o de salas pre definidas
		ASala sala1 = new ASala(1, 200, "Sala Basica", 0, "Nenhum");
		ASala sala2 = new ASala(2, 200, "Sala XD", 0.1, "Bonequinho do morfeu");
		ASala sala3 = new ASala(3, 150, "Sala Super Confortavel", 0.12, "Bonequinho do morfeu e um combo de pipoca");
		ASala sala4 = new ASala(4, 100, "Sala Luxo", 0.15,
				"Bonequinho do morfeu, um combo de pipoca,\n\t refrigerante e chocolate");
		cinema.adicionarSala(sala1);
		cinema.adicionarSala(sala2);
		cinema.adicionarSala(sala3);
		cinema.adicionarSala(sala4);
		// Cria��o de Filmes pre definidos
		BFilme filme1 = new BFilme("A Maldi��o de Morfeu", "Drama", sala1, "Onde todos dormem", 160);
		cinema.adicionarFilme(filme1);
		filme1.setId(cinema.getFilmes().indexOf(filme1) + 1);
		BFilme filme2 = new BFilme("A Maldi��o de Morfeu", "Drama", sala2, "Onde todos dormem", 160);
		cinema.adicionarFilme(filme2);
		filme2.setId(cinema.getFilmes().indexOf(filme2) + 1);
		BFilme filme3 = new BFilme("A Maldi��o de Morfeu", "Drama", sala3, "Onde todos dormem", 160);
		cinema.adicionarFilme(filme3);
		filme3.setId(cinema.getFilmes().indexOf(filme3) + 1);
		BFilme filme4 = new BFilme("A Maldi��o de Morfeu", "Drama", sala4, "Onde todos dormem", 160);
		cinema.adicionarFilme(filme4);
		filme4.setId(cinema.getFilmes().indexOf(filme4) + 1);

		boolean iniciar = true;
		cinema.definirValorIngresso(10.00);
		do {
			System.out.println("\n\n"
					+ "----- CINE MORFEU -----"
					+ "\n|"
					+ "\n|1 -> COMPRAR BILHETE"
					+ "\n|2 -> CATALOGO "
					+ "\n|3 -> SALAS "
					+ "\n|4 -> ARRECADACAO"
					+ "\n|5 -> CADASTROS"
					+ "\n|6 -> SAIR [X]"
					+ "\n|_____________________");
			System.out.print("|Opcao: ");
			int op1 = ler.nextInt();
			switch (op1) {
				case 1:
					comprarBilhete(cinema);
					break;
				case 2:
					catalogo(cinema);
					break;
				case 3:
					listarSalas(cinema);
					break;
				case 4:
					System.out.println("--Total Arrecado Pelo Cinema Foi: " + cinema.getArrecadacao() + " Reais--");
					break;
				case 5:
					System.out.println(
							"\n\n"
									+ "\n ----- CADASTRO -----"
									+ "\n |"
									+ "\n |1 -> SALA"
									+ "\n |2 -> FILME "
									+ "\n |3 -> VOLTAR [X]"
									+ "\n |__________________");
					System.out.print("|Opcao: ");
					int op2 = ler.nextInt();
					if (op2 == 1)
						cadastrarSala(cinema);
					if (op2 == 2)
						cadastrarFilme(cinema);
					break;
				case 6:
					System.out.println("\n----------------\nSistema Encerrado \n"
							+ "Obrigado por ultilizar o CineMorfeu");
					System.exit(0);
					break;
				default:
					System.out.println("\n----------------\n !!! Opcao Invalida");
			}

		} while (iniciar);
	}

	private static void comprarBilhete(CineMorfeu cinema) {
		Scanner ler = new Scanner(System.in);
		catalogo(cinema);
		int op;
		int qtd;
		System.out.print("- Selecione o ID do filme: ");
		op = ler.nextInt();
		ArrayList<BFilme> filmes = cinema.getFilmes();
		for (BFilme filme : filmes) {
			if (filme.getId() == op) {
				System.out.print("- Quantidade de Ingresso: ");
				qtd = ler.nextInt();
				cinema.venderIngresso(filme, qtd);
			}
		}
	}

	private static void cadastrarSala(CineMorfeu cinema) {
		Scanner ler = new Scanner(System.in);
		String nome;
		int capacidade;
		int numero;
		float tx;
		String brinde;
		System.out.print("\n\n____CADASTRO DE SALA____");
		System.out.print("|-> Numero: ");
		numero = ler.nextInt();
		System.out.print("|-> Nome da Sala: ");
		nome = ler.next();
		System.out.print("|-> Capacidade: ");
		capacidade = ler.nextInt();
		System.out.print("|-> Taxa: ");
		tx = ler.nextFloat();
		System.out.print("|-> Brinde: ");
		brinde = ler.next();

		ASala sala = new ASala(numero, capacidade, nome, tx, brinde);
		cinema.adicionarSala(sala);
	}

	private static void listarSalas(CineMorfeu cinema) {
		ArrayList<ASala> salas = cinema.getSalas();
		System.out.println("------- SALAS CADASTRADAS ------");
		for (ASala sala : salas) {
			System.out.println(sala);
		}
	}

	private static void cadastrarFilme(CineMorfeu cinema) {

		Scanner ler = new Scanner(System.in);
		String nome;
		String tipo;
		String descricao;
		int duracao;
		int opSala;
		ArrayList<ASala> salas = cinema.getSalas();
		ASala cadSala;
		System.out.println("\n\n-------Salas ------");
		for (ASala sala : salas) {
			System.out.println("| [" + sala.getNumero() + "] - " + sala.getNomeSala());
		}

		System.out.println("\n____CADASTRO DE FILMES____");
		System.out.print("|-> Titulo: ");
		nome = ler.nextLine();
		System.out.print("|-> Genero: ");
		tipo = ler.nextLine();
		System.out.print("|-> Descricao: ");
		descricao = ler.nextLine();
		System.out.print("|-> Duracao: ");
		duracao = ler.nextInt();
		System.out.print("|-> Numero da Sala: ");
		opSala = ler.nextInt();

		for (ASala sala : salas) {
			if (sala.getNumero() == opSala) {
				cadSala = sala;
				BFilme filme = new BFilme(nome, tipo, cadSala, descricao, duracao);
				cinema.adicionarFilme(filme);
				filme.setId(cinema.getFilmes().indexOf(filme) + 1);
			}
		}

	}

	private static void catalogo(CineMorfeu cinema) {
		ArrayList<BFilme> filmes = cinema.getFilmes();
		System.out.println("------- FILMES CADASTRADOS ------");
		for (BFilme filme : filmes) {
			System.out.println(filme);
		}
	}
}