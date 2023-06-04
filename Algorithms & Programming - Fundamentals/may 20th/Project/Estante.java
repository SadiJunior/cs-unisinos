import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Estante
{
    private String nome;
    private List<Livro> livros;

    public Estante()
    {
        this.livros = new ArrayList<Livro>();
    }
    
    public Estante(List<Livro> livros)
    {
        this.livros = livros;
    }
    
    public Estante(String nome)
    {
        this();
        this.nome = nome;
    }
    
    public Estante(List<Livro> livros, String nome)
    {
        this(livros);
        this.nome = nome;
    }
    
    public List<Livro> getLivros()
    {
        return this.livros;
    }
    
    public void addLivro(Livro livro)
    {
        this.livros.add(livro);
    }
    
    public void removeLivro(Livro livro)
    {
        this.livros.remove(livro);
    }
    
    public Boolean verificaLivro(String titulo)
    {
        Livro livro = this.findLivro(titulo);
        
        return livro != null;
    }
    
    public double verificaDesconto(String titulo)
    {
        Livro livro = this.findLivro(titulo);
        
        if (livro instanceof Novo)
        {
            Novo livroNovo = (Novo) livro;
            
            return livroNovo.getValorDeDesconto();
        }
        
        return -1;
    }
    
    public void imprimeEdicoes()
    {
        for (Livro livro : this.livros)
        {
            if (livro instanceof Antigo)
            {
                Antigo livroAntigo = (Antigo) livro;
                
                System.out.println(String.format(
                    "Edição %d",
                    livroAntigo.getNumDaEdicao()));
            }
        }
    }
    
    public void imprimeLivroPorAnoDesc()
    {
        List<Livro> livrosOrdenados = new ArrayList<Livro>(this.livros);
        
        int size = livrosOrdenados.size();
        
        // Bubble sort para ordenar os livros em ordem decrescente
        for (int i = 0; i < size - 1; i++)
        {
            for (int j = i; j < size - i - 1; j++)
            {
                Livro livro1 = livrosOrdenados.get(i);
                Livro livro2 = livrosOrdenados.get(j + 1);
                
                // Se o ano do segundo livro for maior que o do primeiro
                if (livro1.getAnoDeCriacao() < livro2.getAnoDeCriacao())
                {
                    // Troca os livros de lugar
                    livrosOrdenados.set(j, livro2);
                    livrosOrdenados.set(j + 1, livro1);
                }
            }
        }
        
        for (Livro livro : livrosOrdenados)
        {
            System.out.println(livro);
        }
    }
    
    public double calculaMediaPreco()
    {
        double total = 0.0;
        
        for (Livro livro : this.livros)
        {
            total += livro.getPreco();
        }
        
        return total / this.livros.size();
    }
    
    private Livro findLivro(String titulo)
    {
        for (Livro livro : this.livros)
        {
            if (livro.getTitulo().equals(titulo))
            {
                return livro;
            }
        }
        
        return null;
    }
}
