/**
 * Classe principal.
 *
 * @author Sadi de Moura Lemes J�nior
 */
public class Principal
{
    /**
     * In�cio da aplica��o.
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
