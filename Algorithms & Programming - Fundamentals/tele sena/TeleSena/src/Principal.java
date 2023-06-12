/**
 * Classe principal.
 *
 * @author Sadi de Moura Lemes Júnior
 */
public class Principal
{
    /**
     * Início da aplicação.
     */
    public static void main(String[] args)
    {
        System.out.println("----------------------------------------------------------------------------------------------");

        ControleTeleSena controle = new ControleTeleSena();

        controle.comecarSorteio();

        System.out.println();
        System.out.println("Fim!");
        System.out.println("----------------------------------------------------------------------------------------------");
    }
}
