public class Computador
{
    private String marca;
    private double velocidade;
    private double preco;
    private String dataDeFabricacao;
    private Boolean isNew;

    public Computador()
    {
    }
    
    public Computador(String marca, double velocidade, double preco, String data, Boolean isNew)
    {
        this.marca = marca;
        this.velocidade = velocidade;
        this.preco = preco;
        this.dataDeFabricacao = data;
        this.isNew = isNew;
    }
    
    public String getMarca()
    {
        return this.marca;
    }
    
    public void setMarca(String marca)
    {
        this.marca = marca;
    }
    
    public double getVelocidade()
    {
        return this.velocidade;
    }
    
    public void setVelocidade(double velocidade)
    {
        this.velocidade = velocidade;
    }
        
    public double getPreco()
    {
        return this.preco;
    }   

            
    public void setPreco(double preco)
    {
        this.preco = preco;
    }
    
    public String getDataDeFabricacao()
    {
        return this.dataDeFabricacao;
    }   
    
    public void setDataDeFabricacao(String data)
    {
        this.dataDeFabricacao = data;
    }   
        
    public Boolean getIsNew()
    {
        return this.isNew;
    }   
        
    public void setIsNew(Boolean isNew)
    {
        this.isNew = isNew;
    }
    
    public void aplicaImposto(double imposto)
    {
        this.preco += this.preco * (imposto / 100);
    }
    
    @Override
    public String toString()
    {   
        String classString = String.format(
            "Computador:\nMarca: %s\nVelocidade: %.2f\nPreço: R$%.2f\nData de fabricação: %s\nÉ novo? %s\n",
            this.marca,
            this.velocidade,
            this.preco,
            this.dataDeFabricacao,
            this.isNew ? "Sim" : "Não");
            
        return classString;
    }
}
