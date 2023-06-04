
/**
 * Essa classe representa o Tamagotchi.
 * 
 * @author Sadi de Moura Lemes Júnior
 */
public class Tamagotchi
{
    // O nome do Tamagotchi.
    private String nome;

    // A idade do Tamagotchi (em dias).
    private int idade;

    // O peso do Tamagotchi (em quilogramas).
    private double peso;
    
    // O estado de vida do Tamagotchi.
    private boolean estaVivo;
    
    // O número de vezes que o Tamagotchi permaneceu acordado consecutivamente.
    private int vezesAcordadoConsecutivamente = 0;

    /**
     * Construtor.
     * Cria uma nova instânica de Tamagotchi.
     * Só um construtor, para obrigar o usuário a dar um nome a seu Tamagotchi.
     * 
     * @param  nome   O nome do Tamagotchi.
     */
    public Tamagotchi(String nome)
    {
        this.nome = nome;
        this.idade = 0;
        this.peso = 1.0;
        this.estaVivo = true;
    }

    /**
     * Pega o nome do Tamagotchi.
     * O nome não tem setter, pois o usuário não deve mudar o nome após instanciar o Tamagotchi.
     * 
     * @return     O nome do Tamagotchi.
     */
    public String getNome()
    {
        return this.nome;
    }

    /**
     * Pega a idade do Tamagotchi.
     * 
     * @return     A idade do Tamagotchi.
     */
    public int getIdade()
    {
        return this.idade;
    }

    /**
     * Seta a idade do Tamagotchi.
     * A idade tem setter privado, pois o usuário não deve mudá-la, ela só deve ser modificada internamente.
     * 
     * @param  idade  A nova idade do Tamagotchi.
     */
    private void setIdade(int idade)
    {
        if (idade < this.idade)
        {
            String errorMessage = (String.format(
                "%s não consegue voltar no tempo... :(",
                this.nome));
                
            throw new IllegalArgumentException(errorMessage);
        }
        
        this.idade = idade;
        this.verificarIdade();
    }

    /**
     * Pega o peso do Tamagotchi.
     * 
     * @return     O peso do Tamagotchi.
     */
    public double getPeso()
    {
        return this.peso;
    }

    /**
     * Seta o peso do Tamagotchi.
     * O peso tem setter privado, pois o usuário não deve mudá-lo, ele só deve ser modificado internamente.
     * 
     * @param  peso  O novo peso do Tamagotchi.
     */
    private void setPeso(double peso)
    {
        // Não pode setar um peso negativo.
        if (peso < 0.00)
        {
            peso = 0.00;
        }
        
        this.peso = peso;
        this.verificarPeso();
    }
    
    /**
     * Pega o estado do Tamagotchi (indicando se está vivo ou não).
     * 
     * @return     O estado do Tamagotchi.
     */
    public boolean estaVivo()
    {
        return this.estaVivo;
    }
    
    /**
     * Seta o estado do Tamagotchi (indicando se está vivo ou não).
     * O estado tem setter privado, pois o usuário não deve mudá-lo, ele só deve ser modificado internamente.
     * 
     * @param  estaVivo  O novo estado do Tamagotchi.
     */
    private void setEstaVivo(boolean estaVivo)
    {
        this.estaVivo = estaVivo;
    }

    /**
     * Roda quando o Tamagotchi sente sono.
     */
    public void sentirSono()
    {
        // Se o Tamagotchi permaneceu acordado 5 vezes seguidas, ele é obrigado a dormir.
        if (this.vezesAcordadoConsecutivamente > 5)
        {
            System.out.println(String.format(
                "%s está exausto e precisa dormir...",
                this.nome));
                
            this.dormir();
            
            return;
        }

        String mensagemDeSono = String.format(
            "%s está com sono...\nO que deseja fazer?\n1 - Dormir\n2 - Permanecer acordado",
            this.nome);
        
        int opcao = pegaOpcaoDoUsuario(mensagemDeSono, 2);
        
        if (opcao == 1)
        {
            this.dormir();
        }
        else
        {
            this.permanecerAcordado();
        }
    }
    
    /**
     * Roda quando o Tamagotchi sente fome.
     */
    public void sentirFome()
    {
        String mensagemDeFome = String.format(
            "%s está com fome...\nO que deseja fazer?\n1 - Comer muito\n2 - Comer pouco\n3 - Não comer",
            this.nome);
            
        int opcao = pegaOpcaoDoUsuario(mensagemDeFome, 3);
        
        if (opcao == 1)
        {
            this.comerMuito();
        }
        else if (opcao == 2)
        {
            this.comerPouco();
        }
        else
        {
            this.naoComer();
        }        
    }
    
    /**
     * Roda quando o Tamagotchi fica entediado.
     */
    public void ficarEntediado()
    {
        String mensagemDeTedio = String.format(
            "%s está entediado...\nO que deseja fazer?\n1 - Correr 10 minutos\n2 - Caminhar 10 minutos",
            this.nome);
            
        int opcao = pegaOpcaoDoUsuario(mensagemDeTedio, 2);
        
        if (opcao == 1)
        {
            this.correr(10.00);
        }
        else
        {
            this.caminhar(10.00);
        }
    }
    
    /**
     * Coloca o Tamagotchi para dormir.
     */
    private void dormir()
    {
        System.out.println(String.format(
            "%s foi dormir...",
            this.nome));
      
        this.vezesAcordadoConsecutivamente = 0;
        
        this.setIdade(this.getIdade() + 1);        
    }

    /**
     * Mantem o Tamagotchi acordado.
     */
    private void permanecerAcordado()
    {
        System.out.println(String.format(
            "%s permaneceu acordado.",
            this.nome));
        
        this.vezesAcordadoConsecutivamente += 1;     
    }

    /**
     * Coloca o Tamagotchi para comer muito.
     */
    private void comerMuito()
    {      
        System.out.println(String.format(
            "%s comeu muito e precisa de uma soneca...",
            this.nome));
            
        this.setPeso(this.getPeso() + 5.00);
        
        if (!this.estaVivo())
        {
            return;
        }
            
        this.dormir();
    }
    
    /**
     * Coloca o Tamagotchi para comer pouco.
     */    
    private void comerPouco()
    {
        System.out.println(String.format(
            "%s comeu pouco...",
            this.nome));
            
        this.setPeso(this.getPeso() + 1.00);         
    }
    
    /**
     * Coloca o Tamagotchi para não comer.
     */    
    private void naoComer()
    {                   
        System.out.println(String.format(
            "%s não comeu...",
            this.nome));
            
        this.setPeso(this.getPeso() - 2.00);
    }
    
    /**
     * Coloca o Tamagotchi para correr x minutos.
     */        
    private void correr(double minutos)
    {
        System.out.println(String.format(
            "%s correu %.2f minutos e precisa comer muito...",
            this.nome,
            minutos));
            
        this.setPeso(this.getPeso() - 4.00);
        
        if (!this.estaVivo())
        {
            return;
        }

        this.comerMuito();
    }
    
    /**
     * Coloca o Tamagotchi para caminhar x minutos.
     */            
    private void caminhar(double minutos)
    {        
        System.out.println(String.format(
            "%s caminhou %.2f minutos e ficou com fome...",
            this.nome,
            minutos));
            
        this.setPeso(this.getPeso() - 1.00);
        
        if (!this.estaVivo())
        {
            return;
        }
        
        this.sentirFome();
    }
    
    /**
     * Verifica a idade do Tamagotchi.
     */
    private void verificarIdade()
    {
        if (this.getIdade() >= 15)
        {
            System.out.println(String.format(
                "%s completou 15 dias e morreu... :(",
                this.nome));

            this.setEstaVivo(false);
        }        
    }
        
    /**
     * Verifica o peso do Tamagotchi.
     */    
    private void verificarPeso()
    {
        if (this.getPeso() <= 0.00)
        {
            System.out.println(String.format(
                "%s ficou desnutrido e morreu... :(",
                this.nome));

            this.setEstaVivo(false);
        }
        else if (this.getPeso() > 20.00)
        {
            System.out.println(String.format(
                "%s ficou muito gordo e explodiu... :(",
                this.nome));

            this.setEstaVivo(false);
        }
    }
            
    /**
     * Pega uma opção do usuário, entre 1 e numDeOpcoes. Exibe a mensagem passada por argumento para o usuário.
     * 
     * @param  mensagem     Mensagem para ser exibida para o usuário.
     * @param  numDeOpcoes  O número de opções possíveis.
     */    
    private static int pegaOpcaoDoUsuario(String mensagem, int numDeOpcoes)
    {
        int opcao = 0;
        
        // Enquanto o usuário não selecionar uma opção válida, continua perguntando.
        while (opcao < 1 || opcao > numDeOpcoes)
        {
            opcao = Teclado.leInt(mensagem);
        }
        
        return opcao;
    }
    
    /**
     * Pega a string que representa o Tamagotchi.
     * 
     * @return     A string representando o Tamagotchi.
     */
    @Override
    public String toString()
    {
        String tamagotchiString = String.format(
            "%s:\nIdade: %d\nPeso: %.2f\nEstá vivo? %s",
            this.getNome(),
            this.getIdade(),
            this.getPeso(),
            this.estaVivo() ? "Sim" : "Não");
        
        return tamagotchiString;
    }
}
