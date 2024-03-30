public class Jogador implements Comparable<Jogador> {
    private String name;
    private int victoryCount;

    private Token token;

    public Jogador(String name, Token token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVictoryCount() {
        return victoryCount;
    }

    public void setVictoryCount(int victoryCount) {
        this.victoryCount = victoryCount;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return String.format(
                "Dados do Jogador:\nNome: %s\nNúmero de vitórias: %d\n",
                name,
                victoryCount);
    }

    @Override
    public int compareTo(Jogador jogador) {
        int otherVictoryCount = jogador.getVictoryCount();

        if (this.victoryCount > otherVictoryCount) {
            return 1;
        }
        else if (this.victoryCount < otherVictoryCount) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
