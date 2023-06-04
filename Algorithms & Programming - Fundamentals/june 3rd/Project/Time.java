public class Time
{
    private String nome;
    private Socio[] socios;
    
    public Time(String nome, int maxSocios)
    {
        this.nome = nome;
        this.socios = new Socio[maxSocios];
    }
      
    public String getNome()
    {
        return this.nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public Socio[] getSocios()
    {
        return this.socios;
    }
    
    public void setSocios(Socio[] socios)
    {
        this.socios = socios;
    }
    
    public Boolean insereSocio(Socio socio)
    {
        for (int i = 0; i < this.socios.length; i++)
        {            
            if (this.socios[i] == null)
            {
                this.socios[i] = socio;
                
                return true;
            }
        }
        
        return false;
    }
    
    public String socioMaisVelho()
    {
        Socio socioMaisVelho = null;
        
        for (int i = 0; i < this.socios.length; i++)
        {
            if (this.socios[i] == null)
            {
                continue;
            }
            
            if (this.socios[i].getIdade() > (socioMaisVelho != null ? socioMaisVelho.getIdade() : 0))
            {
                socioMaisVelho = this.socios[i];
            }
        }
        
        return socioMaisVelho.getNome();
    }
    
    public void imprimeSocios()
    {
        StringBuilder sociosString = new StringBuilder();
        
        for (int i = 0; i < this.socios.length; i++)
        {
            if (this.socios[i] == null)
            {
                continue;
            }
            
            sociosString.append(
                String.format(
                    "%d. %s",
                    i + 1,
                    this.socios[i].toString()));
                    
            sociosString.append("\n");
        }
        
        System.out.println(sociosString.toString());
    }
    
    @Override
    public String toString()
    {       
        String timeString = String.format(
            "Dados do time:\nNome: %s\nNúmero de Sócios: %d\n",
            this.nome,
            this.socios.length);
            
        return timeString;
    }
}
