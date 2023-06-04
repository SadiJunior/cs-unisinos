public class Lampada
{
    private Boolean estaLigada;

    public Lampada()
    {
    }

    public Lampada(Boolean estaLigada)
    {
        this.estaLigada = estaLigada;
    }
    
    public Boolean getEstaLigada()
    {
        return this.estaLigada;   
    }
    
    public void setEstaLigada(Boolean estaLigada)
    {
        this.estaLigada = estaLigada;   
    }
        
    @Override
    public String toString()
    {   
        String classString = String.format(
            "Estado da Lâmpada: %s\n",
            this.estaLigada ? "Ligada" : "Desligada");
            
        return classString;
    }
}
