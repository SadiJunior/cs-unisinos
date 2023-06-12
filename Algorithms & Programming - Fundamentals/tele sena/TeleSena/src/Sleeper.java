/**
 * Essa classe centraliza os métodos de Sleep.
 *
 * @author Sadi de Moura Lemes Júnior
 */
public class Sleeper
{
    /**
     * Roda um Sleep pelos milisegundos passados.
     *
     * @param milliseconds O tempo em milisegundos para ficar em sleep.
     */
    public static void sleep(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (Exception e)
        {
        }
    }

    /**
     * Roda um Sleep pelos milisegundos passados. Enquanto roda o sleep, printa na tela "..." (com n número de pontos).
     *
     * @param milliseconds O tempo em milisegundos para ficar em sleep.
     */
    public static void sleepComPontos(int milliseconds, int numDePontos)
    {
        int tempoEntrePontos = Math.round(milliseconds / numDePontos);

        for (int i = 0; i < numDePontos; i++)
        {
            System.out.print(".");
            sleep(tempoEntrePontos);
        }
    }
}
