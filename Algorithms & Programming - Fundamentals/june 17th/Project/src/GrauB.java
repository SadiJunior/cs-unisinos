public class GrauB extends Grau
{
    private double notaAtividades;
    private double notaSeminario;
    private double notaParticipacao;

    public GrauB()
    {
        super();

        this.notaAtividades = 0.00;
        this.notaSeminario = 0.00;
        this.notaParticipacao = 0.00;
    }

    public GrauB(String dataDeComeco, String dataDeFim, double notaAtividades, double notaSeminario, double notaParticipacao)
    {
        super(dataDeComeco, dataDeFim);

        this.notaAtividades = notaAtividades;
        this.notaSeminario = notaSeminario;
        this.notaParticipacao = notaParticipacao;
    }

    public double getNotaAtividades()
    {
        return this.notaAtividades;
    }

    public void setNotaAtividades(double notaAtividades)
    {
        this.notaAtividades = notaAtividades;
    }

    public double getNotaSeminario()
    {
        return this.notaSeminario;
    }

    public void setNotaSeminario(double notaSeminario)
    {
        this.notaSeminario = notaSeminario;
    }

    public double getNotaParticipacao()
    {
        return this.notaParticipacao;
    }

    public void setNotaParticipacao(double notaParticipacao)
    {
        this.notaParticipacao = notaParticipacao;
    }

    public double calculaNotaFinal()
    {
        return
            this.getNotaAtividades() * 0.30 +
            this.getNotaSeminario() * 0.60 +
            this.getNotaParticipacao() * 0.10;
    }

    @Override
    public String toString()
    {
        String grauBString = String.format(
            "Grau B:\nNota das Atividades: %.2f\nNota do Seminário: %.2f\nNota de Participação: %.2f",
            this.getNotaAtividades(),
            this.getNotaSeminario(),
            this.getNotaParticipacao());

        return grauBString;
    }
}
