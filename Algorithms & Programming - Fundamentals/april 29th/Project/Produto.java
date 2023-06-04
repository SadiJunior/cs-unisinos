public class Produto
{
    private String nome;
    private double valor;
    private String descricao;
    private int quantidadeEmEstoque;

    public Produto()
    {
    }

    public Produto(String nome, double valor, String descricao, int quantidadeEmEstoque)
    {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public double getValor()
    {
        return this.valor;
    }
    
    public void setValor(double valor)
    {
        this.valor = valor;
    }
        
    public String getDescricao()
    {
        return this.descricao;
    }
     
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
           
    public int getQuantidadeEmEstoque()
    {
        return this.quantidadeEmEstoque;
    }
             
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque)
    {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }      
    @Override
    public String toString()
    {   
        String classString = String.format(
            "Produto:\nNome: %s\nValor: R$%.2f\nDescrição: %s\nQuantidade em estoque: %d\n",
            this.nome,
            this.valor,
            this.descricao,
            this.quantidadeEmEstoque);
            
        return classString;
    }
}
