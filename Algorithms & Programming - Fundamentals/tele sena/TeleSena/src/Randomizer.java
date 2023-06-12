import java.util.Arrays;

/**
 * Essa classe centraliza os m�todos de randomiza��o de valores.
 *
 * @author Sadi de Moura Lemes J�nior
 */
public class Randomizer
{
    /**
     * Pega um array de ints aleat�rios, de valores entre min e max, com o tamanho passado.
     *
     * @param min O valor m�nimo de valores a serem sorteados.
     * @param max O valor m�ximo de valores a serem sorteados.
     * @param tamanho O tamanho do array.
     * @return Um array de ints aleat�rios, de valores entre min e max, com o tamanho passado.
     */
    public static int[] pegaIntsAleatoriosEntre(int min, int max, int tamanho)
    {
        int[] intsAleatorios = new int[tamanho];
        int i = 0;

        while (i < tamanho)
        {
            int intAleatorio = pegaIntAleatorioEntre(min, max);

            // Se o array n�o tem o valor aleat�rio
            if (!Arrays.stream(intsAleatorios).anyMatch(valor -> valor == intAleatorio))
            {
                intsAleatorios[i] = intAleatorio;
                i += 1;
            }
        }

        return intsAleatorios;
    }

    /**
     * Pega um inteiro aleat�rio entre os argumentos min e max.
     *
     * @param  min  O limite m�nimo.
     * @param  max  O limite m�ximo.
     * @return      Um n�mero aleat�rio entre min e max.
     */
    public static int pegaIntAleatorioEntre(int min, int max)
    {
        int numDePossibilidades = max - min + 1;

        return (int)((Math.random() * numDePossibilidades) + min);
    }
}
