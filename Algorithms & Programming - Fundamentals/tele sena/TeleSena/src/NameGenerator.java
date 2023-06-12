/**
 * Essa classe centraliza os m�todos de gera��o de nomes de Pessoas.
 *
 * @author Sadi de Moura Lemes J�nior
 */
public class NameGenerator
{
    /**
     * Pega um nome gerado aleatoriamente.
     *
     * @return Um nome gerado aleatoriamente.
     */
    public static String pegaNomeAleatorio()
    {
        int indexAleatorioNome = Randomizer.pegaIntAleatorioEntre(0, nomes.length - 1);
        int indexAleatorioSobrenome = Randomizer.pegaIntAleatorioEntre(0, sobrenomes.length - 1);

        String nome = nomes[indexAleatorioNome];
        String sobrenome = sobrenomes[indexAleatorioSobrenome];

        String nomeCompleto = String.format("%s %s", nome, sobrenome);

        return nomeCompleto;
    }

    // Array com nomes gen�ricos.
    private static String[] nomes = new String[]
    {
            "Ana",
            "Beatriz",
            "Carlos",
            "Daniel",
            "Eduardo",
            "Fernanda",
            "Gustavo",
            "Helena",
            "Ingrid",
            "Jo�o",
            "Karen",
            "Lucas",
            "Maria",
            "Nat�lia",
            "Ot�vio",
            "Paula",
            "Rafael",
            "Sabrina",
            "Thiago",
            "Vanessa",
            "Xavier",
            "Yasmin",
            "Zoe",
            "Alexandre",
            "Bianca",
            "Caio",
            "Denise",
            "Elias",
            "Fl�via",
            "Gabriel",
            "Helo�sa",
            "Isabela",
            "Jonathan",
            "Kamila",
            "Leandro",
            "Manuela",
            "Natasha",
            "Oct�vio",
            "Patr�cia",
            "Rafaela",
            "Sergio",
            "Tatiana",
            "Vinicius",
            "Wagner",
            "Yuri",
            "Zara",
    };

    // Array com sobrenomes gen�ricos.
    private static String[] sobrenomes = new String[]
    {
            "Andrade",
            "Barbosa",
            "Campos",
            "Dias",
            "Estrada",
            "Ferreira",
            "Gomes",
            "Henriquez",
            "Ibrahim",
            "Jesus",
            "Klein",
            "Lima",
            "Martins",
            "Nascimento",
            "Oliveira",
            "Pereira",
            "Quintana",
            "Ramos",
            "Santos",
            "Teixeira",
            "Uchoa",
            "Vargas",
            "Weber",
            "Xavier",
            "Yamamoto",
            "Zimmermann",
            "Albuquerque",
            "Borges",
            "Castro",
            "Dantas",
            "Esteves",
            "Fonseca",
            "Gon�alves",
            "Hernandez",
            "In�cio",
            "Jardim",
            "Kowalski",
            "Lopes",
            "Mendes",
            "Navarro",
            "Oliveira",
            "Pires",
            "Queiroz",
            "Ribeiro",
            "Santana",
            "Trindade",
            "Urbano",
            "Valente",
            "Watanabe",
            "Xavier",
            "Yamashita",
            "Zanetti",
    };
}
