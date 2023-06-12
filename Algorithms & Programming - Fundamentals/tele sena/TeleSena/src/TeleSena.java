/**
 * Essa classe representa a Tele Sena.
 *
 * @author Sadi de Moura Lemes J�nior
 */
public class TeleSena
{
    // Constante com o pre�o fixo das Tele Senas.
    private static final double Preco = 10.00;

    // O n�mero de conjuntos da Tele Sena.
    private static final int NumDeConjuntos = 2;

    // O n�mero de n�meros em cada conjunto.
    private static final int NumDeNumeros = 25;

    // O pre�o da Tele Sena
    private double preco;

    // Os conjuntos da Tele Sena.
    private int[][] conjuntos;

    /**
     * Construtor.
     * Cria uma nova inst�nica de Tele Sena.
     */
    public TeleSena()
    {
        this.preco = Preco;
        this.gerarConjuntos();
    }

    /**
     * Construtor.
     * Cria uma nova inst�nica de Tele Sena.
     *
     * @param preco O pre�o da Tele Sena.
     */
    public TeleSena(double preco)
    {
        this.preco = preco;
        this.gerarConjuntos();
    }

    /**
     * Pega o pre�o da Tele Sena.
     *
     * @return O pre�o da Tele Sena.
     */
    public double getPreco()
    {
        return preco;
    }

    /**
     * Seta o pre�o da Tele Sena.
     *
     * @param preco O pre�o da Tele Sena.
     */
    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    /**
     * Pega o pre�o da Tele Sena.
     * Os conjuntos n�o tem setter pois n�o podem ser modificados.
     *
     * @return O pre�o da Tele Sena.
     */
    public int[][] getConjuntos()
    {
        return this.conjuntos;
    }

    /**
     * Pega a string que representa a Tele Sena.
     *
     * @return A string que representa a Tele Sena.
     */
    @Override
    public String toString()
    {
        StringBuilder conjuntosSB = new StringBuilder();
        int[][] conjuntos = this.getConjuntos();

        // Gera a string dos Conjuntos.
        for (int i = 0; i < conjuntos.length; i++)
        {
            conjuntosSB.append(String.format("Conjunto %d: ", i + 1));

            conjuntosSB.append(ArrayPrinter.arrayToString(conjuntos[i]));
        }

        String teleSenaString = String.format(
                "Dados da Tele Sena:\nPre�o: R$%.2f\n%s",
                this.getPreco(),
                conjuntosSB.toString());

        return teleSenaString;
    }

    /**
     * Gera os conjuntos da inst�ncia de forma aleat�ria.
     */
    private void gerarConjuntos()
    {
        this.conjuntos = new int[NumDeConjuntos][NumDeNumeros];

        for (int i = 0; i < this.conjuntos.length; i++)
        {
            this.conjuntos[i] = Randomizer.pegaIntsAleatoriosEntre(1, 60, NumDeNumeros);
        }
    }
}
