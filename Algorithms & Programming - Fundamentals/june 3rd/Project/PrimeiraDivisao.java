public class PrimeiraDivisao extends Time
{
    private int posicaoRanking;

    public PrimeiraDivisao(String nome, int maxSocios)
    {
        super(nome, maxSocios);
    }
    
    public PrimeiraDivisao(String nome, int maxSocios, int posicaoRanking)
    {
        super(nome, maxSocios);
        
        this.posicaoRanking = posicaoRanking;
    }
    
    public int getPosicaoRanking()
    {
        return this.posicaoRanking;
    }
    
    public void setPosicaoRanking(int posicaoRanking)
    {
        this.posicaoRanking = posicaoRanking;
    }

    @Override
    public String toString()
    {       
        String timeString = String.format(
            "Dados do time de Primeira Divisão:\nNome: %s\nNúmero de Sócios: %d\nPosição no Ranking Nacional de Clubes: %d\n",
            this.getNome(),
            this.getSocios().length,
            this.posicaoRanking);
            
        return timeString;
    }
}
