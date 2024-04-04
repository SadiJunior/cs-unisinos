/*
 * @author Sadi Junior
 *
 * Algoritmos e Programa��o: Estruturas Lineares
 * April, 2024
 */


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrincipalLabirinto {

    public static void main(String args[]) {
        Labirinto labirinto = LabirintoFactory.createLabirinto("labirinto-1.txt");

        if (labirinto == null) {
            System.out.println("N�o foi poss�vel criar o Labirinto.");
            return;
        }

        boolean existeCaminho = labirinto.resolveLabirinto();

        String resultMessage = existeCaminho ?
            "Existe um caminho para o labirinto" :
            "N�o existe um caminho para o labirinto";

        FileWriter fileWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter("saidaLabirinto.txt");
            printWriter = new PrintWriter(fileWriter);


            printWriter.write(resultMessage);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            printWriter.close();
        }
    }
}
