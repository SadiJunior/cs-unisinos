import java.util.Arrays;

/**
 * Essa classe representa uma Pessoa participante da Tele Sena.
 *
 * @author Sadi de Moura Lemes Júnior
 */
public class Pessoa
{
    // O nome da pessoa.
    private String nome;

    // O array de Tele Senas da pessoa.
    private TeleSena[] teleSenas;

    // O valor da premiação recebida, caso a pessoa for ganhadora.
    private double premiacao;

    /**
     * Construtor.
     * Cria uma nova instânica de Pessoa.
     *
     * @param nome O nome da Pessoa.
     */
    public Pessoa(String nome)
    {
        this.nome = nome;
        this.teleSenas = new TeleSena[ControleTeleSena.MaxTeleSenas];
        this.premiacao = 0.00;
    }

    /**
     * Pega o nome da pessoa.
     * Não tem setter, pois não pode mudar o nome.
     *
     * @return O nome da pessoa.
     */
    public String getNome()
    {
        return this.nome;
    }

    /**
     * Pega a premiação da pessoa.
     *
     * @return A premiação da pessoa.
     */
    public double getPremiacao()
    {
        return this.premiacao;
    }

    /**
     * Seta a premiação da pessoa, caso tenha ganhado a Tele Sena.
     *
     * @param premiacao O valor da premiação.
     */
    public void setPremiacao(double premiacao)
    {
        this.premiacao = premiacao;
    }

    /**
     * Pega as Tele Senas da pessoa.
     *
     * @return As Tele Senas da pessoa.
     */
    public TeleSena[] getTeleSenas()
    {
        return this.teleSenas;
    }

    /**
     * Adiciona uma Tele Sena nas Tele Senas da pessoa.
     *
     * @param teleSena A Tele Sena a ser adicionada.
     * @return Um booleano indicando se adicionou com sucesso ou não.
     */
    public boolean addTeleSena(TeleSena teleSena)
    {
        TeleSena[] teleSenas = this.getTeleSenas();

        for (int i = 0; i < teleSenas.length; i++)
        {
            if (teleSenas[i] == null)
            {
                teleSenas[i] = teleSena;
                return true;
            }
        }

        return false;
    }

    /**
     * Remove uma Tele Sena das Tele Senas da pessoa.
     *
     * @param teleSena A Tele Sena a ser removida.
     * @return Um booleano indicando se removeu com sucesso ou não.
     */
    public boolean removeTeleSena(TeleSena teleSena)
    {
        TeleSena[] teleSenas = this.getTeleSenas();

        for (int i = 0; i < teleSenas.length; i++)
        {
            // Verifica as referências
            if (teleSenas[i] == teleSena)
            {
                teleSenas[i] = null;
                return true;
            }
        }

        return false;
    }

    /**
     * Pega a string que representa a Pessoa.
     *
     * @return A string que representa a Pessoa.
     */
    @Override
    public String toString()
    {
        String pessoaString = String.format(
                "%s:\nNúmero de Tele Senas: %d\nPremiação: R$%.2f",
                this.getNome(),
                Arrays.stream(this.getTeleSenas()).filter(teleSena -> teleSena != null).count(),
                this.getPremiacao());

        return pessoaString;
    }
}
