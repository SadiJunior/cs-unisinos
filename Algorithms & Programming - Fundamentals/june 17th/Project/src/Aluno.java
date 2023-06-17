public class Aluno
{
    private String nome;
    private Grau ga;
    private Grau gb;

    public Aluno(String nome)
    {
        this.nome = nome;
        this.ga = new GrauA();
        this.gb = new GrauB();
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Grau getGa()
    {
        return this.ga;
    }

    public void setGa(Grau ga)
    {
        this.ga = ga;
    }

    public Grau getGb()
    {
        return this.gb;
    }

    public void setGb(Grau gb)
    {
        this.gb = gb;
    }

    public double calculaNotaFinal()
    {
        double notaGrauA = ((GrauA) this.ga).calculaNotaFinal();
        double notaGrauB = ((GrauB) this.gb).calculaNotaFinal();

        return
            notaGrauA * 0.33 +
            notaGrauB * 0.67;
    }

    @Override
    public String toString()
    {
        String alunoString = String.format(
            "Aluno %s\nNota final: %.2f\nNota do Grau A: %.2f\nNota do Grau B: %.2f",
            this.getNome(),
                this.calculaNotaFinal(),
                ((GrauA) this.ga).calculaNotaFinal(),
                ((GrauB) this.gb).calculaNotaFinal());

        return alunoString;
    }
}
