public class Turma
{
    private String codigo;

    private Aluno[] alunos;

    public Turma(String codigo, int numDeAlunos)
    {
        this.codigo = codigo;

        this.alunos = new Aluno[numDeAlunos];
    }

    public String getCodigo()
    {
        return this.codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public Aluno[] getAlunos()
    {
        return this.alunos;
    }

    public boolean insereAluno(Aluno aluno)
    {
        Aluno[] alunos = this.getAlunos();

        for (int i = 0; i < alunos.length; i++)
        {
            if (alunos[i] == null)
            {
                alunos[i] = aluno;

                return true;
            }
        }

        return false;
    }

    public double mediaNotasTurma()
    {
        Aluno[] alunos = this.getAlunos();
        double totalNotas = 0.00;

        if (alunos.length == 0)
        {
            return -1.00;
        }

        for (Aluno aluno : alunos)
        {
            if (aluno != null)
            {
                totalNotas += aluno.calculaNotaFinal();
            }
        }

        return totalNotas / alunos.length;
    }

    public boolean alteraNotasGrauA(String nomeDoAluno, double notaTrabalhos, double notaProva)
    {
        Aluno[] alunos = this.getAlunos();

        for (Aluno aluno : alunos)
        {
            if (aluno == null)
            {
                continue;
            }

            if (aluno.getNome().equals(nomeDoAluno))
            {
                GrauA gaAluno = (GrauA) aluno.getGa();

                gaAluno.setNotaTrabalhos(notaTrabalhos);
                gaAluno.setNotaProva(notaProva);

                return true;
            }
        }

        return false;
    }

    public boolean alteraNotasGrauB(String nomeDoAluno, double notaAtividades, double notaSeminario, double notaParticipacao)
    {
        Aluno[] alunos = this.getAlunos();

        for (Aluno aluno : alunos)
        {
            if (aluno == null)
            {
                continue;
            }

            if (aluno.getNome().equals(nomeDoAluno))
            {
                GrauB gbAluno = (GrauB) aluno.getGb();

                gbAluno.setNotaAtividades(notaAtividades);
                gbAluno.setNotaSeminario(notaSeminario);
                gbAluno.setNotaParticipacao(notaParticipacao);

                return true;
            }
        }

        return false;
    }
}
