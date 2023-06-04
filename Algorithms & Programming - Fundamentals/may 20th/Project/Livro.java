public class Livro
{
    private String titulo;
    private String autor;
    private double preco;
    private int anoDeCriacao;

    public Livro()
    {
    }
    
    public Livro(String titulo, String autor, double preco, int anoDeCriacao)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.anoDeCriacao = anoDeCriacao;
    }
    
    public String getTitulo()
    {
        return this.titulo;
    }
    
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
    
    public String getAutor()
    {
        return this.autor;
    }
    
    public void setAutor(String autor)
    {
        this.autor = autor;
    }
    
    public double getPreco()
    {
        return this.preco;
    }
    
    public void setPreco(double preco)
    {
        this.preco = preco;
    }
    
    public int getAnoDeCriacao()
    {
        return this.anoDeCriacao;
    }
    
    public void setAnoDeCriacao(int anoDeCriacao)
    {
        this.anoDeCriacao = anoDeCriacao;
    }
    
    @Override
    public String toString()
    {
        String livroString = String.format(
            "Livro %s:\nAutor: %s\nPreço: %.2f\nAno de criação: %d",
            this.titulo,
            this.autor,
            this.preco,
            this.anoDeCriacao);
        
        return livroString;
    }
}
