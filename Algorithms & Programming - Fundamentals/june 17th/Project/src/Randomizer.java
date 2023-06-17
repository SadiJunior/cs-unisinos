import java.util.Arrays;

/**
 * Essa classe centraliza os m�todos de randomiza��o de valores.
 *
 * @author Sadi de Moura Lemes J�nior
 */
public class Randomizer
{
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
