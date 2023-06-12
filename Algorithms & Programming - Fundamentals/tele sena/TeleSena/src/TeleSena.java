/**
 * Essa classe representa a Tele Sena.
 *
 * @author Sadi de Moura Lemes Júnior
 */
public class TeleSena
{
    // Constante com o preço fixo das Tele Senas.
    private static final double Preco = 10.00;

    // O número de conjuntos da Tele Sena.
    private static final int NumDeConjuntos = 2;

    // O número de números em cada conjunto.
    private static final int NumDeNumeros = 25;

    // O preço da Tele Sena
    private double preco;

    // Os conjuntos da Tele Sena.
    private int[][] conjuntos;

    /**
     * Construtor.
     * Cria uma nova instânica de Tele Sena.
     */
    public TeleSena()
    {
        this.preco = Preco;
        this.gerarConjuntos();
    }

    /**
     * Construtor.
     * Cria uma nova instânica de Tele Sena.
     *
     * @param preco O preço da Tele Sena.
     */
    public TeleSena(double preco)
    {
        this.preco = preco;
        this.gerarConjuntos();
    }

    /**
     * Pega o preço da Tele Sena.
     *
     * @return O preço da Tele Sena.
     */
    public double getPreco()
    {
        return preco;
    }

    /**
     * Seta o preço da Tele Sena.
     *
     * @param preco O preço da Tele Sena.
     */
    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    /**
     * Pega o preço da Tele Sena.
     * Os conjuntos não tem setter pois não podem ser modificados.
     *
     * @return O preço da Tele Sena.
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
                "Dados da Tele Sena:\nPreço: R$%.2f\n%s",
                this.getPreco(),
                conjuntosSB.toString());

        return teleSenaString;
    }

    /**
     * Gera os conjuntos da instância de forma aleatória.
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
