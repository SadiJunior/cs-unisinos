import java.util.List;
import java.util.ArrayList;

public class Principal
{
    public static void main(String[] args)
    {
        int minTimes = 1;
        int maxTimes = 50;
        
        int numDeTimes = 0;
        
        System.out.println("---------------------------");
        
        // Pega o número de times
        while (numDeTimes < minTimes || numDeTimes > maxTimes)
        {
            numDeTimes = Teclado.leInt(
                String.format(
                    "Digite um valor entre %d e %d: ",
                    minTimes,
                    maxTimes));
        }

        Time[] times = new Time[numDeTimes];
        
        int numDeTimesPrimeiraDivisao = 0;
        
        System.out.println();
        System.out.println("Criando os times...");
        System.out.println();
        
        // Cria os times
        for (int i = 0; i < numDeTimes; i++)
        {
            int sorteioDeDivisao = pegaIntAleatorioEntre(1, 2);
            
            String nomeDoTime = String.format("Time %d", i + 1);
            int maxDeSocios = pegaIntAleatorioEntre(10, 50);
            
            if (sorteioDeDivisao == 1)
            {
                numDeTimesPrimeiraDivisao += 1;
                                
                times[i] = new PrimeiraDivisao(
                    nomeDoTime,
                    maxDeSocios,
                    numDeTimesPrimeiraDivisao);
            }
            else if (sorteioDeDivisao == 2)
            {
                int anosSeguidos = pegaIntAleatorioEntre(0, 100);
                
                times[i] = new SegundaDivisao(
                    nomeDoTime,
                    maxDeSocios,
                    anosSeguidos);
            }
        }
        
        System.out.println();
        System.out.println("Simulando as posições do Ranking Nacional de Clubes...");
        System.out.println();
        
        // Simula (randomiza) as posicoes       
        
        // Pega todas as posicoes possiveis a partir do número de times
        List<Integer> posicoes = new ArrayList<Integer>();
        for (int i = 1; i <= numDeTimesPrimeiraDivisao; i++)
        {
            posicoes.add(i);
        }
                    
        for (int i = 0; i < numDeTimes; i++)
        {
            if (times[i] instanceof PrimeiraDivisao)
            {
                 PrimeiraDivisao timePrimeiraDivisao = (PrimeiraDivisao) times[i];
                 
                 int indexAleatorio = pegaIntAleatorioEntre(0, posicoes.size() - 1);
                 int posicaoAleatoria = posicoes.get(indexAleatorio);
                 
                 timePrimeiraDivisao.setPosicaoRanking(posicaoAleatoria);
                 
                 // Não pode ter dois times na mesma posição
                 posicoes.remove(indexAleatorio);
            }
        }
        
        int numDeSocios = 20;
        
        System.out.println();
        System.out.println("Inserindo sócios...");
        System.out.println();
        
        // Insere os sócios
        for (int i = 0; i < times.length; i++)
        {
            if (times[i] == null)
            {
                continue;
            }
            
            System.out.println(String.format("%s:", times[i].getNome()));
                            
            for (int j = 0; j < numDeSocios; j++)
            {
                Socio socio = new Socio(
                        pegaNomeAleatorio(),
                        pegaIntAleatorioEntre(18, 100));
                        
                Boolean adicionou = times[i].insereSocio(socio);
                        
                if (adicionou)
                {
                    System.out.println(
                        String.format(
                            "%s adicionado com sucesso!",
                            socio.getNome()));
                }
                else
                {
                    System.out.println(
                        String.format(
                            "Falha ao adicionar %s.",
                            socio.getNome()));
                }
            }
        }
        
        System.out.println();
        System.out.println("Informações dos times:");
        System.out.println();
        
        // Imprime as informações dos times
        for (int i = 0; i < times.length; i++)
        {
            if (times[i] != null)
            {
                System.out.println(times[i].toString());
            }
        }
        
        System.out.println("Informações dos sócios dos times:");
        
        // Imprime as informações dos sócios dos times
        for (int i = 0; i < times.length; i++)
        {
            if (times[i] != null)
            {
                times[i].imprimeSocios();
            } 
        }
        
        System.out.println();
        System.out.println("Sócios mais velhos de cada time:");
        System.out.println();
        
        // Imprime os sócios mais velhos dos times
        for (int i = 0; i < times.length; i++)
        {
            if (times[i] != null)
            {
               System.out.println(String.format(
                   "%s: %s é o sócio mais velho",
                   times[i].getNome(),
                   times[i].socioMaisVelho())); 
            }
        }
        
        System.out.println();
        System.out.println("Time melhor colocado no Ranking Nacional de Clubes:");
        System.out.println();
        
        // Imprime as informações do time melhor colocado no ranking nacional
        for (int i = 0; i < times.length; i++)
        {
            if (times[i] instanceof PrimeiraDivisao)
            {
                 PrimeiraDivisao timePrimeiraDivisao = (PrimeiraDivisao) times[i];
                 
                 if (timePrimeiraDivisao.getPosicaoRanking() == 1)
                 {
                     System.out.println(
                         String.format(
                         "Primeiro colocado do Ranking Nacional de Clubes: %s",
                         timePrimeiraDivisao.toString()));
                 }
            }
        }
        
        System.out.println();
        System.out.println("Fim");        
        System.out.println("---------------------------");
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
    
    private static String pegaNomeAleatorio()
    {
        int indexAleatorio = pegaIntAleatorioEntre(0, nomesAleatorios.length - 1);
        
        return nomesAleatorios[indexAleatorio];
    }
    
    // O ideal seria ler isso de um arquivo externo
    private static String[] nomesAleatorios = new String[]
    {
        "Davi",
        "Pedro",
        "Lucas",
        "Rafael",
        "Enzo",
        "Samuel",
        "Leonardo",
        "Pietro",
        "Benjamin",
        "Joaquim",
        "Bryan",
        "Benício",
        "Enzo Gabriel",
        "Thomas",
        "Emanuel",
        "Enrico",
        "Lorenzo",
        "Lucas",
        "Rafael",
        "David",
        "Eduardo",
        "Hugo",
        "Tomás",
        "Augusto",
        "André",
        "Levi",
        "Emanuel",
        "Aarão",
        "Diogo",
        "Alexandre",
        "Diego",
        "António",
        "Lourenço",
        "Apólo",
        "Júlio",
        "Abel",
        "Santiago",
        "Raul",
        "Carlos",
        "José",
        "Wilian",
        "César",
        "Abraão",
        "Renato",
        "Edgar",
        "Adriano",
        "Cristiano",
        "Duarte",
        "Juliano",
        "Anderson",
    };
}
