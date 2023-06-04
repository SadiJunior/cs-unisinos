public class Socio
{
    private String nome;
    private int idade;
    
    public Socio(String nome, int idade)
    {
        this.nome = nome;
        this.idade = idade;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public int getIdade()
    {
        return this.idade;
    }
    
    public void setIdade(int idade)
    {
        this.idade = idade;
    }

    @Override
    public String toString()
    {
        String socioString = String.format(
            "Dados do sócio:\nNome: %s\nIdade: %d",
            this.nome,
            this.idade);
            
        return socioString;
    }
}
