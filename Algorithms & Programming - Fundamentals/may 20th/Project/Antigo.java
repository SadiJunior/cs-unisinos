public class Antigo extends Livro
{
    private int numDaEdicao;

    public Antigo(String titulo, String autor, double preco, int anoDeCriacao, int numDaEdicao)
    {
        super(titulo, autor, preco, anoDeCriacao);
        this.numDaEdicao = numDaEdicao;
    }
    
    public int getNumDaEdicao()
    {
        return this.numDaEdicao;
    }
    
    public void setNumDaEdicao(int numDaEdicao)
    {
        this.numDaEdicao = numDaEdicao;
    }
}
