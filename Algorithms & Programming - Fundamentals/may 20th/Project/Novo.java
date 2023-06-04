public class Novo extends Livro
{
    private double valorDeDesconto;

    public Novo(String titulo, String autor, double preco, int anoDeCriacao, double valorDeDesconto)
    {
        super(titulo, autor, preco, anoDeCriacao);
        this.valorDeDesconto = valorDeDesconto;
        this.setPreco(this.getPreco() * valorDeDesconto);
    }
    
    public double getValorDeDesconto()
    {
        return this.valorDeDesconto;
    }
    
    public void setValorDeDesconto(double valorDeDesconto)
    {
        this.valorDeDesconto = valorDeDesconto;
    }
}
