
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
        Tamagotchi tamagotchi = new Tamagotchi("Luisito");
        
        int contagemDeDesejos = 0;
        
        System.out.println("---------------------------");

        while (tamagotchi.estaVivo())
        {
            int desejo = pegaIntAleatorioEntre(1, 3);
            contagemDeDesejos += 1;
            
            System.out.println(String.format(
                "Desejo %d: ",
                contagemDeDesejos));
            
            if (desejo == 1)
            {
                tamagotchi.sentirSono();
            }
            else if (desejo == 2)
            {
                tamagotchi.sentirFome();
            }
            else
            {
                tamagotchi.ficarEntediado();
            }
            
            System.out.println("---------------------------");
            System.out.println(tamagotchi.toString());
            System.out.println("---------------------------");
        }
    }

    /**
     * Pega um inteiro aleatório entre os argumentos min e max.
     * 
     * @param  min  O limite mínimo.
     * @param  max  O limite máximo.
     * @return      Um número aleatório entre min e max.   
     */    
    private static int pegaIntAleatorioEntre(int min, int max)
    {      
        int numDePossibilidades = max - min + 1;
        
        return (int)((Math.random() * numDePossibilidades) + min);
    }
}
