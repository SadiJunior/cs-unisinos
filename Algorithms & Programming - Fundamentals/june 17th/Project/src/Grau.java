public class Grau
{
    private String dataDeComeco;
    private String dataDeFim;

    public Grau()
    {
        this.dataDeComeco = null;
        this.dataDeFim = null;
    }

    public Grau(String dataDeComeco, String dataDeFim)
    {
        this.dataDeComeco = dataDeComeco;
        this.dataDeFim = dataDeFim;
    }

    public String getDataDeComeco()
    {
        return this.dataDeComeco;
    }

    public void setDataDeComeco(String dataDeComeco)
    {
        this.dataDeComeco = dataDeComeco;
    }

    public String getDataDeFim()
    {
        return this.dataDeFim;
    }

    public void setDataDeFim(String dataDeFim)
    {
        this.dataDeFim = dataDeFim;
    }

    @Override
    public String toString()
    {
        String grauString = String.format(
                "Grau:\nData de inicío: %s\nData de fim: %s",
                this.getDataDeComeco(),
                this.getDataDeFim());

        return grauString;
    }
}
