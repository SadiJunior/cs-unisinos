public class GrauA extends Grau
{
    private double notaTrabalhos;
    private double notaProva;

    public GrauA()
    {
        super();

        this.notaTrabalhos = 0.00;
        this.notaProva = 0.00;
    }

    public GrauA(String dataDeComeco, String dataDeFim, double notaTrabalhos, double notaProva)
    {
        super(dataDeComeco, dataDeFim);

        this.notaTrabalhos = notaTrabalhos;
        this.notaProva = notaProva;
    }

    public double getNotaTrabalhos()
    {
        return this.notaTrabalhos;
    }

    public void setNotaTrabalhos(double notaTrabalhos)
    {
        this.notaTrabalhos = notaTrabalhos;
    }

    public double getNotaProva()
    {
        return this.notaProva;
    }

    public void setNotaProva(double notaProva)
    {
        this.notaProva = notaProva;
    }

    public double calculaNotaFinal()
    {
        return
            this.getNotaTrabalhos() * 0.30 +
            this.getNotaProva() * 0.70;
    }

    @Override
    public String toString()
    {
        String grauAString = String.format(
            "Grau A:\nNota dos Trabalhos: %.2f\nNota da Prova: %.2f",
            this.getNotaTrabalhos(),
            this.getNotaProva());

        return grauAString;
    }
}
