public class SegundaDivisao extends Time
{
    private int anosSeguidos;

    public SegundaDivisao(String nome, int maxSocios)
    {
        super(nome, maxSocios);
    }
    
    public SegundaDivisao(String nome, int maxSocios, int anosSeguidos)
    {
        super(nome, maxSocios);
        
        this.anosSeguidos = anosSeguidos;
    }
    
    public int getAnosSeguidos()
    {
        return this.anosSeguidos;
    }
    
    public void setAnosSeguidos(int anosSeguidos)
    {
        this.anosSeguidos = anosSeguidos;
    }

    @Override
    public String toString()
    {       
        String timeString = String.format(
            "Dados do time de Segunda Divisão:\nNome: %s\nNúmero de Sócios: %d\nAnos seguidos: %d\n",
            this.getNome(),
            this.getSocios().length,
            this.anosSeguidos);
            
        return timeString;
    }
}
