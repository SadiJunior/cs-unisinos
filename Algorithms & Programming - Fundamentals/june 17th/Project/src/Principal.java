/**
 * Trabalho para a aula do dia 17/06.
 *
 * @author Sadi de Moura Lemes Júnior
 */
public class Principal
{
    /**
     * Início da aplicação.
     */
    public static void main(String[] args)
    {
        System.out.println("----------------------------------------------------------------------------------------------");

        String codigoDaTurma = Teclado.leString("Informe o código da turma: ");
        int numMaxDeAlunos = Randomizer.pegaIntAleatorioEntre(1, 50);

        System.out.println(
            String.format(
                "Número máximo de alunos na turma: %d",
                numMaxDeAlunos));

        System.out.println("Gerando a Turma...");
        Turma turma = new Turma(codigoDaTurma, numMaxDeAlunos);

        int numDeAlunosParaInserir = Randomizer.pegaIntAleatorioEntre(1, 100);

        System.out.println();
        System.out.println(
            String.format(
                "%d alunos vão tentar ser adicionados na turma.",
                numDeAlunosParaInserir));

        for (int i = 0; i < numDeAlunosParaInserir; i++)
        {
            Aluno novoAluno = new Aluno(NameGenerator.pegaNomeAleatorio());

            boolean inseriuComSucesso = turma.insereAluno(novoAluno);

            if (inseriuComSucesso)
            {
                System.out.println(
                    String.format(
                        "%s foi inserido com sucesso!",
                        novoAluno.getNome()));
            }
            else
            {
                System.out.println(
                    String.format(
                        "%s não pôde ser inserido.",
                        novoAluno.getNome()));
            }

            double notaTrabalhos = Randomizer.pegaIntAleatorioEntre(0, 100) / 10.00;
            double notaProva = Randomizer.pegaIntAleatorioEntre(0, 100) / 10.00;
            turma.alteraNotasGrauA(novoAluno.getNome(), notaTrabalhos, notaProva);

            double notaAtividades = Randomizer.pegaIntAleatorioEntre(0, 100) / 10.00;
            double notaSeminario = Randomizer.pegaIntAleatorioEntre(0, 100) / 10.00;
            double notaParticipacao = Randomizer.pegaIntAleatorioEntre(0, 100) / 10.00;
            turma.alteraNotasGrauB(novoAluno.getNome(), notaAtividades, notaSeminario, notaParticipacao);
        }

        System.out.println("Fim da inserção de alunos.");

        System.out.println();
        double mediaDaTurma = turma.mediaNotasTurma();
        System.out.println(
            String.format(
                "Média da turma: %.2f",
                mediaDaTurma));

        System.out.println();
        System.out.println("Resultados individuais:");

        for (Aluno aluno : turma.getAlunos())
        {
            if (aluno == null)
            {
                continue;
            }

            if (aluno.calculaNotaFinal() >= 8.00)
            {
                System.out.println(
                    String.format(
                        "Aluno %s: Passou com distinção!",
                        aluno.getNome()));
            }
            else if (aluno.calculaNotaFinal() >= 6.00)
            {
                System.out.println(
                    String.format(
                        "Aluno %s: Passou por média!",
                        aluno.getNome()));
            }
            else
            {
                System.out.println(
                    String.format(
                        "Aluno %s: Ficou em Grau C.",
                        aluno.getNome()));
            }
        }

        System.out.println();
        System.out.println("Fim!");
        System.out.println("----------------------------------------------------------------------------------------------");
    }
}
