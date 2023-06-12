import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Essa classe representa o Controle da Tele Sena.
 *
 * @author Sadi de Moura Lemes Júnior
 */
public class ControleTeleSena
{
    // O número máximo de Tele Senas que cada pessoa pode ter.
    public static final int MaxTeleSenas = 15;

    // Constante com o número de pessoas que vão jogar a Tele Sena.
    private static final int NumDePessoas = 20;

    // Constante com o número de Tele Senas disponíveis para venda.
    private static final int NumDeTeleSenas = 300;

    // Os números possíveis para o sorteio.
    private static final int[] NumerosPossiveis = IntStream.rangeClosed(1, 60).toArray();

    // As Tele Senas disponíveis para venda.
    private TeleSena[] teleSenas;

    // As pessoas que vão jogar a Tele Sena.
    private Pessoa[] pessoas;

    // O saldo do Controle Tele Sena.
    private double saldo;

    // Armazena os números sorteados. Usada internamente.
    private int[] numerosSorteados;

    // O número de Tele Senas vendidas.
    private int numDeTeleSenasVendidas;

    /**
     * Construtor.
     * Cria uma instânica de Controle Tele Sena.
     */
    public ControleTeleSena()
    {
        this.teleSenas = new TeleSena[NumDeTeleSenas];
        this.pessoas = new Pessoa[NumDePessoas];
        this.saldo = 0.00;
        this.numDeTeleSenasVendidas = 0;

        this.gerarTeleSenas();
        this.gerarPessoas();

        System.out.println();
        System.out.println(String.format("Prêmio total: R$%.2f!", this.getPremio()));
        System.out.println();
    }

    /**
     * Pega as pessoas que vão jogar a Tele Sena.
     *
     * @return As pessoas que vão jogar a Tele Sena.
     */
    public Pessoa[] getPessoas()
    {
        return this.pessoas;
    }

    /**
     * Pega as Tele Senas disponíveis para venda.
     *
     * @return As Tele Senas disponíveis para venda.
     */
    public TeleSena[] getTeleSenas()
    {
        return this.teleSenas;
    }

    /**
     * Pega o saldo do Controle Tele Sena.
     *
     * @return O saldo do Controle Tele Sena.
     */
    public double getSaldo()
    {
        return this.saldo;
    }

    /**
     * Seta o saldo do Controle Tele Sena.
     *
     * @param saldo O saldo a ser definido.
     */
    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

    /**
     * Pega o valor total do prêmio.
     *
     * @return O valor total do prêmio.
     */
    public double getPremio()
    {
        return this.getSaldo() * 0.80;
    }

    /**
     * Pega o lucro total.
     *
     * @return O lucro total.
     */
    public double getLucro()
    {
        return this.getSaldo() - this.getPremio();
    }

    /**
     * Pega o número de Tele Senas vendidas.
     *
     * @return O número de Tele Senas vendidas.
     */
    public int getNumDeTeleSenasVendidas()
    {
        return this.numDeTeleSenasVendidas;
    }

    /**
     * Seta o número de Tele Senas vendidas.
     *
     * @param numDeTeleSenasVendidas O novo número de Tele Senas vendidas.
     */
    public void setNumDeTeleSenasVendidas(int numDeTeleSenasVendidas)
    {
        this.numDeTeleSenasVendidas = numDeTeleSenasVendidas;
    }

    /**
     * Adiciona uma Pessoa nas Pessoas do Controle Tele Sena.
     *
     * @param pessoa A Pessoa a ser adicionada.
     * @return Um booleano indicando se adicionou com sucesso ou não.
     */
    public boolean addPessoa(Pessoa pessoa)
    {
        Pessoa[] pessoas = this.getPessoas();

        for (int i = 0; i < pessoas.length; i++)
        {
            if (pessoas[i] == null)
            {
                pessoas[i] = pessoa;
                return true;
            }
        }

        return false;
    }

    /**
     * Remove uma Pessoa das Pessoas do Controle Tele Sena.
     *
     * @param nome O nome da Pessoa a ser removida.
     * @return Um booleano indicando se removeu com sucesso ou não.
     */
    public boolean removePessoa(String nome)
    {
        Pessoa[] pessoas = this.getPessoas();

        for (int i = 0; i < pessoas.length; i++)
        {
            // Verifica os nomes.
            if (pessoas[i].getNome().equals(nome))
            {
                pessoas[i] = null;
                return true;
            }
        }

        return false;
    }

    /**
     * Vende uma Tele Sena.
     *
     * @return A Tele Sena a ser vendida.
     */
    public TeleSena venderTeleSena()
    {
        TeleSena[] teleSenas = this.getTeleSenas();

        // Pega as Tele Senas que estão disponíveis (não são nullas no array de Tele Senas, ou seja, não foram vendidas ainda).
        // Precisa do TeleSena[]::new para converter os Objects para TeleSena (toArray retorna Objects para arrays de objetos).
        TeleSena[] teleSenasDisponiveis = Arrays.stream(this.getTeleSenas())
                .filter(teleSena -> teleSena != null)
                .toArray(TeleSena[]::new);

        // Se todas já tiverem sido vendidas.
        if (teleSenasDisponiveis.length == 0)
        {
            return null;
        }

        int indexAleatorio = Randomizer.pegaIntAleatorioEntre(0, teleSenasDisponiveis.length - 1);

        TeleSena teleSenaParaVender = teleSenasDisponiveis[indexAleatorio];

        this.setSaldo(this.getSaldo() + teleSenaParaVender.getPreco());
        this.setNumDeTeleSenasVendidas(this.getNumDeTeleSenasVendidas() + 1);

        return teleSenaParaVender;
    }

    /**
     * Começa o Sorteio.
     */
    public void comecarSorteio()
    {
        System.out.println();
        System.out.print("Começando o Sorteio em ");
        System.out.print("3");
        Sleeper.sleepComPontos(1000, 3);
        System.out.print("2");
        Sleeper.sleepComPontos(1000, 3);
        System.out.print("1");
        Sleeper.sleepComPontos(1000, 3);
        System.out.print(" Já!");

        this.numerosSorteados = new int[60];
        Pessoa[] ganhadores;

        int cont = 1;

        while (true)
        {
            int numeroSorteado = this.sortearNumero();

            if (numeroSorteado == -1)
            {
                System.out.println();
                System.out.println("Os números acabaram!");
                return;
            }

            System.out.println();
            System.out.println(String.format("Número %d: %d", cont, numeroSorteado));

            if (this.numerosSorteados.length >= 25)
            {
                ganhadores = this.verificarSeAlguemGanhou();

                if (Arrays.stream(ganhadores).anyMatch(pessoa -> pessoa != null))
                {
                    break;
                }
            }

            Sleeper.sleepComPontos(500, 3);

            cont += 1;
        }

        this.encerrarSorteio(ganhadores);
    }

    /**
     * Encerra o Sorteio. Printa as informações necessárias.
     *
     * @param ganhadores Os ganhadores da Tele Sena.
     */
    private void encerrarSorteio(Pessoa[] ganhadores)
    {
        System.out.println();
        System.out.print("O sorteio foi encerrado");
        Sleeper.sleepComPontos(1000, 3);
        System.out.print(" E já temos vencedores!");
        System.out.println();

        ganhadores = Arrays.stream(ganhadores)
                .filter(pessoa -> pessoa != null)
                .toArray(Pessoa[]::new);

        double premioParaCadaGanhador = this.getPremio() / ganhadores.length;

        for (Pessoa ganhador : ganhadores)
        {
            ganhador.setPremiacao(premioParaCadaGanhador);
        }

        int[] numerosSorteados = Arrays.stream(this.numerosSorteados)
                .filter(num -> num != 0)
                .toArray();

        System.out.println(
            String.format(
                "Números sorteados: %s\nQuantidade de Tele Senas vendidas: %d\nPrêmio total: R$%.2f\nQuantidade de ganhadores: %d\nPrêmio para cada ganhador: R$%.2f",
                ArrayPrinter.arrayToString(numerosSorteados),
                this.getNumDeTeleSenasVendidas(),
                this.getPremio(),
                ganhadores.length,
                premioParaCadaGanhador));

        System.out.println();
        System.out.println("Ganhadores:");

        for (Pessoa ganhador : ganhadores)
        {
            System.out.println(ganhador);
        }

        System.out.println();
        System.out.println(
            String.format(
                "Valor total de Tele Senas vendidas: R$%.2f\nLucro obtido pelo Sílvio Santos: R$%.2f",
                this.getSaldo(),
                this.getLucro()));
    }

    /**
     * Método para sortear números.
     * Contém tratamento para não sortear números repetidos.
     *
     * @return O número sorteado.
     */
    private int sortearNumero()
    {
        int[] numerosDisponiveis = Arrays.stream(NumerosPossiveis)
                .filter(numero -> !Arrays.stream(this.numerosSorteados).anyMatch(num -> num == numero))
                .toArray();

        if (numerosDisponiveis.length == 0)
        {
            return -1;
        }

        int indexAleatorio = Randomizer.pegaIntAleatorioEntre(0, numerosDisponiveis.length - 1);

        int numeroSorteado = numerosDisponiveis[indexAleatorio];

        // Coloca o número no array de números sorteados.
        for (int i = 0; i < this.numerosSorteados.length; i++)
        {
            if (this.numerosSorteados[i] == 0)
            {
                this.numerosSorteados[i] = numeroSorteado;
                break;
            }
        }

        return numeroSorteado;
    }

    /**
     * Verifica se alguém ganhou a Tele Sena.
     *
     * @return Um array de Pessoas, com o(s) ganhador(es) da Tele Sena.
     */
    private Pessoa[] verificarSeAlguemGanhou()
    {
        Pessoa[] ganhadores = new Pessoa[NumDePessoas];

        loopPessoas: for (Pessoa pessoa : this.getPessoas())
        {
            if (pessoa == null)
            {
                continue;
            }

            for (TeleSena teleSena : pessoa.getTeleSenas())
            {
                if (teleSena == null)
                {
                    continue;
                }

                if (this.verificarTeleSena(teleSena))
                {
                    for (int i = 0; i < ganhadores.length; i++)
                    {
                        if (ganhadores[i] == null)
                        {
                            ganhadores[i] = pessoa;
                            continue loopPessoas;
                        }
                    }
                }
            }
        }

        return ganhadores;
    }

    /**
     * Verifica se a Tele Sena passada é ganhadora.
     *
     * @param teleSena A Tele Sena a ser verificada.
     * @return Um booleano indicando se a Tele Sena passada é ganhadora.
     */
    private boolean verificarTeleSena(TeleSena teleSena)
    {
        int[][] conjuntos = teleSena.getConjuntos();

        for (int[] conjunto : conjuntos)
        {
            int acertos = 0;

            for (int numeroSorteado : this.numerosSorteados)
            {
                for (int numero : conjunto)
                {
                    if (numero == numeroSorteado)
                    {
                        acertos += 1;

                        if (acertos >= 25)
                        {
                            return true;
                        }

                        break;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Gera as pessoas que vão jogar a Tele Sena.
     */
    private void gerarPessoas()
    {
        System.out.println();
        System.out.print("Gerando Pessoas");
        Sleeper.sleepComPontos(1000, 3);
        System.out.println();


        Pessoa[] pessoas = this.getPessoas();

        int i = 0;

        while (i < pessoas.length)
        {
            String nome = NameGenerator.pegaNomeAleatorio();

            boolean nomeJaExiste = Arrays.stream(pessoas)
                    .filter(pessoa -> pessoa != null)
                    .anyMatch(pessoa -> pessoa.getNome().equals(nome));

            if (nomeJaExiste)
            {
                continue;
            }

            Pessoa novaPessoa = new Pessoa(nome);

            int numDeTeleSenas = Randomizer.pegaIntAleatorioEntre(1, MaxTeleSenas);

            for (int j = 0; j < numDeTeleSenas; j++)
            {
                novaPessoa.addTeleSena(this.venderTeleSena());
            }

            System.out.println(
                String.format(
                    "Gerando %s. Número de Tele Senas compradas: %d",
                    nome,
                    numDeTeleSenas));

            pessoas[i] = novaPessoa;
            i += 1;
        }

        System.out.println(String.format("%d Pessoas geradas.", pessoas.length));
        System.out.println();
    }

    /**
     * Gera as Tele Senas que serão vendidas.
     */
    private void gerarTeleSenas()
    {
        System.out.println();
        System.out.print("Gerando Tele Senas");
        Sleeper.sleepComPontos(1000, 3);
        System.out.println();

        TeleSena[] teleSenas = this.getTeleSenas();

        for (int i = 0; i < teleSenas.length; i++)
        {
            teleSenas[i] = new TeleSena();
        }

        System.out.println(String.format("%d Tele Senas geradas.", teleSenas.length));
        System.out.println();
    }
}
