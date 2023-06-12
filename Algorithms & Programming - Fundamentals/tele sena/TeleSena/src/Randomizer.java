import java.util.Arrays;

/**
 * Essa classe centraliza os métodos de randomização de valores.
 *
 * @author Sadi de Moura Lemes Júnior
 */
public class Randomizer
{
    /**
     * Pega um array de ints aleatórios, de valores entre min e max, com o tamanho passado.
     *
     * @param min O valor mínimo de valores a serem sorteados.
     * @param max O valor máximo de valores a serem sorteados.
     * @param tamanho O tamanho do array.
     * @return Um array de ints aleatórios, de valores entre min e max, com o tamanho passado.
     */
    public static int[] pegaIntsAleatoriosEntre(int min, int max, int tamanho)
    {
        int[] intsAleatorios = new int[tamanho];
        int i = 0;

        while (i < tamanho)
        {
            int intAleatorio = pegaIntAleatorioEntre(min, max);

            // Se o array não tem o valor aleatório
            if (!Arrays.stream(intsAleatorios).anyMatch(valor -> valor == intAleatorio))
            {
                intsAleatorios[i] = intAleatorio;
                i += 1;
            }
        }

        return intsAleatorios;
    }

    /**
     * Pega um inteiro aleatório entre os argumentos min e max.
     *
     * @param  min  O limite mínimo.
     * @param  max  O limite máximo.
     * @return      Um número aleatório entre min e max.
     */
    public static int pegaIntAleatorioEntre(int min, int max)
    {
        int numDePossibilidades = max - min + 1;

        return (int)((Math.random() * numDePossibilidades) + min);
    }
}
