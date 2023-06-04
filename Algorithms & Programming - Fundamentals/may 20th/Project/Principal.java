public class Principal
{
    public static final int NumDeLivros = 3;
    
    /**
     * Início da aplicação.
     */
    public static void main(String[] args)
    {
        Estante estante = new Estante("Estante 1");
                
        System.out.println("---------------------------");

        for (int i = 0; i < NumDeLivros; i++)
        {
            int sorteioDeLivro = pegaIntAleatorioEntre(1, 3);
                            
            Livro livro;
            
            String titulo = Teclado.leString("Título: ");
            String autor = Teclado.leString("Autor: ");
            double preco = Teclado.leDouble("Preço: ");
            int anoDeCriacao = Teclado.leInt("Ano de criação: ");
            
            if (sorteioDeLivro == 1)
            {
                System.out.println("É um Livro");
                
                livro = new Livro(
                    titulo,
                    autor,
                    preco,
                    anoDeCriacao);
            }
            else if (sorteioDeLivro == 2)
            {
                System.out.println("É um Livro Antigo");

                int numDaEdicao = Teclado.leInt("Número da edição: ");
                
                livro = new Antigo(
                    titulo,
                    autor,
                    preco,
                    anoDeCriacao,
                    numDaEdicao);
            }
            else
            {
                System.out.println("É um Livro Novo");                
                
                double valorDeDesconto = Teclado.leDouble("Valor de desconto (%): ");
                
                livro = new Novo(
                    titulo,
                    autor,
                    preco,
                    anoDeCriacao,
                    valorDeDesconto);
            }
            
            estante.addLivro(livro);
            
            System.out.println("---------------------------");
        }
        
        String tituloParaPesquisar = Teclado.leString("Digite um título para ser pesquisado: ");
        
        if (estante.verificaLivro(tituloParaPesquisar))
        {
            System.out.println(
                String.format(
                    "O livro %s existe.",
                    tituloParaPesquisar));
        }
        else
        {
            System.out.println(
                String.format(
                    "O livro %s não existe.",
                    tituloParaPesquisar));
        }
        
        System.out.println("Livros em ordem decrescente por ano de criação:");
        estante.imprimeLivroPorAnoDesc();
        
        System.out.println(
            String.format(
                "Média do preço dos livros: %.2f",
                estante.calculaMediaPreco()));
                
        System.out.println("Edições dos livros (apenas livros Antigos tem esse dado):");
        estante.imprimeEdicoes();
        
        String tituloParaPesquisarDesconto = Teclado.leString("Digite um título para pesquisar seu desconto (apenas livros Novos tem esse dado):");        

        double desconto = estante.verificaDesconto(tituloParaPesquisarDesconto);
        
        if (desconto == -1)
        {
            System.out.println(
                String.format(
                    "O título %s não tem desconto.",
                    tituloParaPesquisarDesconto));
        }
        else
        {
            System.out.println(
                String.format(
                    "Desconto do título %s: %.2f",
                    tituloParaPesquisarDesconto,
                    desconto));
        }
        
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
}
