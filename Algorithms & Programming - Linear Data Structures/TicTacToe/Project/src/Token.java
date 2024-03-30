public enum Token {
    Empty('\u0000'), // Null in Unicode.
    X('X'),
    O('O'),
    ;

    private char symbol;

    Token(char symbol) {
        this.symbol = symbol;
    }

    public char toChar() {
        return symbol;
    }
}
