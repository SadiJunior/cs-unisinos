/**
 * Trabalho para a aula presencial do dia 29/04/2023.
 * 
 * @author Sadi Júnior 
 * @version 29/04/2023
 */
public class Principal
{
    public static void main(String[] args)
    {
        int numeroDeObjetos = 3;
        System.out.println("\nInício da aplicação.\n");
        
        System.out.println("\nInforme as seguintes informações: \n");
        
        Cor[] cores = new Cor[numeroDeObjetos];
        
        System.out.println("Cores: \n");
        
        for (int i = 0; i < numeroDeObjetos; i++)
        {
            System.out.println(String.format("\nCor %d", i + 1));
            
            int r = Teclado.leInt("R: ");
            int g = Teclado.leInt("G: ");
            int b = Teclado.leInt("B: ");
            
            cores[i] = new Cor(r, g, b);
        }
        
        Computador[] computadores = new Computador[numeroDeObjetos];
        
        System.out.println("\nComputadores:");
        
        for (int i = 0; i < numeroDeObjetos; i++)
        {
            System.out.println(String.format("\nComputador %d", i + 1));
            
            String marca = Teclado.leString("Marca: ");
            double velocidade = Teclado.leDouble("Velocidade: ");
            double preco = Teclado.leDouble("Preço: ");
            String dataDeFabricacao = Teclado.leString("Data de fabricação: ");
            char isNewChar = Teclado.leChar("É novo? ('s' ou 'n') ");
            Boolean isNew = Character.toLowerCase(isNewChar) == 's';
    
            computadores[i] = new Computador(
                marca,
                velocidade,
                preco,
                dataDeFabricacao,
                isNew);
        }
                
        Lampada[] lampadas = new Lampada[numeroDeObjetos];
        
        System.out.println("\nLâmpadas:");
        
        for (int i = 0; i < numeroDeObjetos; i++)
        {
            System.out.println(String.format("\nLâmpada %d", i + 1));
            
            char estaLigadaChar = Teclado.leChar("Está ligada? ('s' ou 'n') ");
            Boolean estaLigada = Character.toLowerCase(estaLigadaChar) == 's';
    
            lampadas[i] = new Lampada(estaLigada);
        }
          
        Produto[] produtos = new Produto[numeroDeObjetos];
        
        System.out.println("\nProdutos:");
        
        for (int i = 0; i < numeroDeObjetos; i++)
        {
            System.out.println(String.format("\nProduto %d", i + 1));
            
            String nome = Teclado.leString("Nome: ");
            double valor = Teclado.leDouble("Valor: ");
            String descricao = Teclado.leString("Descrição: ");
            int quantidadeEmEstoque = Teclado.leInt("Quantidade em estoque: ");
    
            produtos[i] = new Produto(
                nome,
                valor,
                descricao,
                quantidadeEmEstoque);
        }
        
        System.out.println("\nDados informados: \n");
        
        System.out.println("\nCores: \n");

        for (Cor cor : cores)
        {
            System.out.println(cor);
            System.out.println();
        }
            
        System.out.println("\nComputadores: \n");

        for (Computador computador : computadores)
        {
            System.out.println(computador);
            System.out.println();
        }
        
        System.out.println("\nLâmpadas: \n");
        
        for (Lampada lampada : lampadas)
        {
            System.out.println(lampada);
            System.out.println();
        }
        
        System.out.println("\nProdutos: \n");

        for (Produto produto : produtos)
        {
            System.out.println(produto);
            System.out.println();
        }
        
        System.out.println("\nAlterando valores:");
        
        Lampada lampada = lampadas[1];
        System.out.println("Antes:");
        System.out.println(lampada);
        lampada.setEstaLigada(!lampada.getEstaLigada());
        System.out.println("Depois:");
        System.out.println(lampada);
        
        Produto produto = produtos[0];
        System.out.println("Antes:");
        System.out.println(produto);
        produto.setQuantidadeEmEstoque(Teclado.leInt("Quantidade em estoque: "));
        System.out.println("Depois:");
        System.out.println(produto);
        
        Computador computador = computadores[2];
        System.out.println("Antes:");
        System.out.println(computador);
        computador.setPreco(Teclado.leDouble("Preço: "));
        System.out.println("Depois:");
        System.out.println(computador);
        
        Cor cor = cores[1];
        System.out.println("Antes:");
        System.out.println(cor);
        cor.setBlue(Teclado.leInt("B: "));
        System.out.println("Depois:");
        System.out.println(cor);
        
        System.out.println("\nAplicando imposto:");
        System.out.println("Antes:");
        System.out.println(computador);
        computador.aplicaImposto(Teclado.leDouble("Imposto: (%)"));
        System.out.println("Depois:");
        System.out.println(computador);
        
        System.out.println("\nFim!\n");
    }
}
