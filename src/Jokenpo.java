import java.util.Random;
import java.util.Scanner;

public class Jokenpo {

	public static void main(String[] args) {

		// Declarando as variáveis utilizadas
		int numeroPartidas = 0;
		int escolhaPC = 0;
		int escolhaJogador = 0;
		int contador = 1;
		int vitoriasJogador = 0;
		int vitoriasPC = 0;
		int valorVitoria = 0;
		int empates = 0;
		String resposta = "S";
		String nomeEscolhaPC = "";
		String nomeEscolhaJogador = "";
		boolean escolhaCorreta = false;

		Scanner ler = new Scanner(System.in);
		Random sorteio = new Random();

		// Montando o menu e escolha das opções
		System.out.println("-----------------------------------");
		System.out.println("     J O G O     J O K E N P O"     );
		System.out.println("-----------------------------------");
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("1 - Pedra");
		System.out.println("2 - Papel");
		System.out.println("3 - Tesoura");
		System.out.println("--------------------------------");
		System.out.println();


		while (resposta.equals("S") || resposta.equals("s")) {
			System.out.print("Digite o número de partidas: ");
			numeroPartidas = ler.nextInt();
			System.out.println();

			// Verificando se a quantidade de partidas é ímpar
			while (numeroPartidas % 2 == 0 || numeroPartidas < 3) {
				System.out.println("Por favor, a quantidade de partidas deve \nser um número ímpar maior ou igual a 3.");
				System.out.println();
				System.out.print("Digite novamente: ");
				numeroPartidas = ler.nextInt();
			}

			// Determinando o placar da vitória
			valorVitoria = (numeroPartidas / 2) + 1;
			System.out.println("O valor da vitória é: " + valorVitoria);
			System.out.println();

			while (contador < numeroPartidas) {
				// Determinando a escolha do PC
				escolhaPC = sorteio.nextInt(3) + 1;

				System.out.println("Partida " + contador);

				if (escolhaPC == 1) {
					nomeEscolhaPC = "Pedra";
				} else if (escolhaPC == 2) {
					nomeEscolhaPC = "Papel";
				} else {
					nomeEscolhaPC = "Tesoura";
				}

				while (escolhaCorreta == false) {

					System.out.print("Escolha uma opção (1 à 3): ");
					escolhaJogador = ler.nextInt();

					// Determinando a escolha do jogador
					if (escolhaJogador == 1) {
						nomeEscolhaJogador = "Pedra";
						escolhaCorreta = true;
					} else if (escolhaJogador == 2) {
						nomeEscolhaJogador = "Papel";
						escolhaCorreta = true;
					} else if (escolhaJogador == 3) {
						nomeEscolhaJogador = "Tesoura";
						escolhaCorreta = true;
					} else {
						System.out.println("Opção incorreta!");
					}

					System.out.println("Você escolheu: " + nomeEscolhaJogador);
					System.out.println("PC escolheu: " + nomeEscolhaPC);
				}

				// Determinando o vencedor
				
				if (escolhaJogador == escolhaPC) {
					System.out.println("Deu empate! :|");
					System.out.println();
					empates++;
				} else if (escolhaJogador == 1 && escolhaPC == 3 || escolhaJogador == 3 && escolhaPC == 2
						|| escolhaJogador == 2 && escolhaPC == 1) {
					System.out.println("Você ganhou esta! :)");
					System.out.println();
					vitoriasJogador++;
				} else if (escolhaJogador == 3 && escolhaPC == 1 || escolhaJogador == 2 && escolhaPC == 3
						|| escolhaJogador == 1 && escolhaPC == 2) {
					System.out.println("Você perdeu esta! :(");
					System.out.println();
					vitoriasPC++;
				}

				escolhaCorreta = false;
				contador++;

				// Verificando se alguém já venceu
				if (vitoriasPC == valorVitoria) {
					System.out.println("O  P C  V E N C E U  O  D E S A F I O ! ! !");
					System.out.println();
					System.out.println("PC: " + vitoriasPC);
					System.out.println("Você: " + vitoriasJogador);
					System.out.println("Empates: " + empates);
					contador = numeroPartidas;
				} else if (vitoriasJogador == valorVitoria) {
					System.out.println("V O C Ê  V E N C E U  O  D E S A F I O ! ! !");
					System.out.println("Você: " + vitoriasJogador);
					System.out.println("PC: " + vitoriasPC);
					System.out.println("Empates: " + empates);
					contador = numeroPartidas;
				} else if (contador == numeroPartidas) {
					numeroPartidas++;
				}

			}

			System.out.println();
			System.out.println("O jogo acabou!");
			System.out.println();
			System.out.print("Deseja jogar novamente (S/N)? ");
			resposta = ler.next();
			System.out.println();

			numeroPartidas = 0;
			escolhaPC = 0;
			escolhaJogador = 0;
			contador = 1;
			vitoriasJogador = 0;
			vitoriasPC = 0;
			valorVitoria = 0;
			empates = 0;
			escolhaCorreta = false;

		}

		System.out.println();
		System.out.println("Fim do jogo!");
		System.out.println("Até a próxima! ;)");
		
		ler.close();

	}

}
