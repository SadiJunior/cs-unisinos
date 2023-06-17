import java.util.Arrays;

/**
 * Essa classe centraliza os métodos de randomização de valores.
 *
 * @author Sadi de Moura Lemes Júnior
 */
public class Randomizer
{
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
