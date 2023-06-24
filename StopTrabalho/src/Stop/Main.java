package Stop;

import java.util.Scanner;
import java.util.Random;

import Stop.model.Player;
import Stop.model.Player2;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("VAMOS CADASTRAR O CORAJOSO(A)\n");
        Player player1 = cadastrarPlayer(scanner);

        System.out.print("QUANTAS CATEGORIAS: ");
        int numcat = scanner.nextInt();
        scanner.nextLine();

        String[] categorias = new String[numcat];
        for (int i = 0; i < numcat; i++) {
            System.out.print("BOTA O NOME AE: ");
            String nomeCategoria = scanner.nextLine();
            categorias[i] = nomeCategoria;
        }

        Random random = new Random();
        char letra = (char) (random.nextInt(26) + 'A');
        System.out.println("A LETRA É: " + letra);

        String[] respostas = new String[numcat];
        long tempoTotal1 = 0;

        for (int j = 0; j < numcat; j++) {
            System.out.print(categorias[j] + ": ");
            long tempoInicial = System.currentTimeMillis();
            String resposta = scanner.nextLine();
            long tempoFinal = System.currentTimeMillis();
            respostas[j] = resposta;
            long tempoResposta = tempoFinal - tempoInicial;
            tempoTotal1 += tempoResposta;
        }

        System.out.println("PARABENS VOCE TERMINOU");

        System.out.print("TEM MAIS UM CORAJOSO(A) PARA JOGAR?? 1- Sim 2- Não\n");
        int x = scanner.nextInt();

        if (x == 1) {
            scanner.nextLine();
            System.out.println("informe a confimação:");

            System.out.println("VAMOS CADASTRAR O SEGUNDO CORAJOSO(A)\n");
            Player player2 = cadastrarPlayer(scanner);

            System.out.println("A LETRA É: " + letra);
            System.out.println("NÃO VALE COPIAR O AMIGUINHO");
            String[] respostas2 = new String[numcat];
            long tempoTotal2 = 0;

            for (int j = 0; j < numcat; j++) {
                boolean respostaValida = false;
                while (!respostaValida) {
                    System.out.print(categorias[j] + ": ");
                    long tempoInicial = System.currentTimeMillis();
                    String resposta = scanner.nextLine();
                    long tempoFinal = System.currentTimeMillis();
                    if (!resposta.equalsIgnoreCase(respostas[j])) {
                        respostas2[j] = resposta;
                        respostaValida = true;
                        long tempoResposta = tempoFinal - tempoInicial;
                        tempoTotal2 += tempoResposta;
                    } else {
                        System.out.println("NÃO É PRA COPIAR >:(");
                    }
                }
            }

            System.out.println("NEM ACREDITO QUE VOCES TERMINARAM!");
            System.out.println("VAMOS VER O VENCEDOR!");

            long Seg1 = tempoTotal1 / 1000;
            long Seg2 = tempoTotal2 / 1000;
            System.out.println("Tempo total de respostas do jogador " + player1.getNome() + ": " + Seg1 + "s");
            System.out.println("Tempo total de respostas do jogador " + player2.getNome() + ": " + Seg2 + "s");

            if (Seg1 > Seg2) {
                System.out.println("O CAMPEÃO É: " + player2.getNome());
            } else if (Seg1 < Seg2) {
                System.out.println("O CAMPEÃO É: " + player1.getNome());
            } else {
                System.out.println("OS CAMPEÕES EMPATARAM.");
            }

        } else {
            System.out.println("BOOOOOA, SEU TEMPO FOI: " + tempoTotal1 / 1000 + "s");
        }

        scanner.close();
    }

    private static Player cadastrarPlayer(Scanner scanner) {
        System.out.println("QUAL SEU NOME: ");
        String nome = scanner.nextLine();

        System.out.println("SUA IDADE: ");
        String idade = scanner.nextLine();

        System.out.println("QUAL SEU SEXO? (CABRA, SUPER WOMAN, OUTRO?): ");
        String sexo = scanner.nextLine();

        return new Player2(nome, idade, sexo);
    }
}
