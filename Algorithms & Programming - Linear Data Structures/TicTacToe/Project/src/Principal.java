/*
 * @author Sadi Junior
 *
 * Algoritmos e Programação: Estruturas Lineares
 * March, 2024
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Principal {
    public static final int PLAYERS_COUNT = 2;

    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Jogo da Velha - By Sadi Junior");
        System.out.println("----------------------------------------------------------------------------");

        Jogador[] jogadores = new Jogador[PLAYERS_COUNT];
        Token[] tokens = new Token[]
            {
                Token.X,
                Token.O
            };

        for (int i = 0; i < PLAYERS_COUNT; i++) {
            Jogador jogador = new Jogador(
                    Teclado.leString(String.format("\nDigite o nome do Jogador %d: ", i + 1)),
                    tokens[i]);

            jogadores[i] = jogador;
        }

        int gridSize;
        do {
            gridSize = Teclado.leInt("\nDigite o tamanho do tabuleiro (deve ser ímpar): ");
        } while (!JogoDaVelha.isValidGridSize(gridSize));

        boolean isPlaying = true;

        while (isPlaying) {
            System.out.println("\n----------------------------------------------------------------------------");
            System.out.println("Começando um novo Jogo da Velha");
            System.out.println("\n");

            for (Jogador jogador : jogadores) {
                System.out.println(
                        String.format(
                                "%s joga com '%c'",
                                jogador.getName(),
                                jogador.getToken().toChar()));
            }

            System.out.println("\n");

            JogoDaVelha jogoDaVelha = new JogoDaVelha(gridSize);
            System.out.println(jogoDaVelha);

            boolean isDraw = false;
            Jogador jogadorAtual = null;
            while (!jogoDaVelha.verificaGanhador()) {
                int numDeJogadas = jogoDaVelha.getNumDeJogadas();
                jogadorAtual = jogadores[numDeJogadas % 2];

                if (numDeJogadas >= gridSize * gridSize) {
                    isDraw = true;
                    break;
                }

                System.out.println("\n----------------------------------------------------------------------------");
                System.out.println(
                        String.format(
                                "Jogada %d - %s joga com '%c'",
                                numDeJogadas + 1,
                                jogadorAtual.getName(),
                                jogadorAtual.getToken().toChar()));
                int row;
                int column;
                do {
                    row = Teclado.leInt(String.format("\nDigite a linha (0 - %d): ", gridSize - 1));
                    column = Teclado.leInt(String.format("Digite a coluna (0 - %d): ", gridSize - 1));
                } while (!jogoDaVelha.realizaJogada(row, column, jogadorAtual.getToken()));

                System.out.println("\n");
                System.out.println(jogoDaVelha);
            }

            System.out.println("\n----------------------------------------------------------------------------");
            System.out.println("FIM DE JOGO!");

            if (isDraw) {
                System.out.println("Empatou!");
            }
            else {
                jogadorAtual.setVictoryCount(jogadorAtual.getVictoryCount() + 1);
                System.out.println(String.format("%s ganhou!", jogadorAtual.getName()));
            }

            // Switches the players Tokens
            Token tempToken = jogadores[0].getToken();
            jogadores[0].setToken(jogadores[1].getToken());
            jogadores[1].setToken(tempToken);

            // Switches the players order
            Jogador tempJogador = jogadores[0];
            jogadores[0] = jogadores[1];
            jogadores[1] = tempJogador;

            char respostaJogarNovamente;
            do {
                respostaJogarNovamente = Teclado.leChar("\nJogar novamente? (s/n)");
            } while (respostaJogarNovamente != 's' && respostaJogarNovamente != 'n');

            isPlaying = respostaJogarNovamente == 's';
        }

        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("Finalizando o Jogo da Velha");

        System.out.println("\nResultados: ");

        // Orders by points (victories)
        Arrays.sort(jogadores);
        for (int i = 0; i < PLAYERS_COUNT; i++) {
            Jogador jogador = jogadores[PLAYERS_COUNT - 1 -i];
            System.out.println(
                    String.format(
                            "%d. %s - %d points",
                            i + 1,
                            jogador.getName(),
                            jogador.getVictoryCount()));
        }

        boolean isDrawResult = jogadores[0].getVictoryCount() == jogadores[1].getVictoryCount();
        if (isDrawResult) {
            System.out.println("\nEscrevendo dados de ambos jogadores no arquivo resultado.txt (pois empatou)");
        }
        else {
            System.out.println(
                    String.format(
                            "\nEscrevendo dados do vencedor (%s) no arquivo resultado.txt",
                            jogadores[PLAYERS_COUNT - 1].getName()));
        }

        FileWriter fileWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter("resultado.txt");
            printWriter = new PrintWriter(fileWriter);

            if (isDrawResult) {
                StringBuilder resultBuilder = new StringBuilder();

                for (Jogador jogador : jogadores) {
                    resultBuilder.append(jogador.toString());
                    resultBuilder.append("\n");
                }

                printWriter.write(resultBuilder.toString());
            }
            else {
                printWriter.write(jogadores[PLAYERS_COUNT - 1].toString());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            printWriter.close();
        }

        System.out.println("Operação concluída");
        System.out.println("----------------------------------------------------------------------------");
    }
}
