public class JogoDaVelha {
    private int gridSize;

    private char[][] grid;

    private int numDeJogadas;

    public JogoDaVelha(int gridSize) {
        this.gridSize = gridSize;
        this.grid = new char[gridSize][gridSize];
        this.numDeJogadas = 0;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getNumDeJogadas() {
        return numDeJogadas;
    }

    public static boolean isValidGridSize(int gridSize) {
        if (gridSize <= 1) {
            return false;
        }

        // Grid must be odd
        return gridSize % 2 != 0;
    }

    @Override
    public String toString() {
        StringBuilder gridBuilder = new StringBuilder();

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                char character = grid[i][j] == Token.Empty.toChar() ?
                        ' ' :
                        grid[i][j];

                if (j == gridSize - 1) {
                    gridBuilder.append(String.format(" %c ", character));
                }
                else {
                    gridBuilder.append(String.format(" %c |", character));
                }
            }

            gridBuilder.append("\n");
            if (i < gridSize - 1) {
                for (int j = 0; j < gridSize; j++) {
                    if (j == gridSize - 1) {
                        gridBuilder.append("---");
                    }
                    else {
                        gridBuilder.append("---|");
                    }
                }

                gridBuilder.append("\n");
            }
        }

        return gridBuilder.toString();
    }

    public boolean realizaJogada(int row, int column, Token token) {
        if (row >= gridSize || column >= gridSize) {
            return false;
        }

        if (row < 0 || column < 0) {
            return false;
        }

        if (grid[row][column] != Token.Empty.toChar()) {
            return false;
        }

        grid[row][column] = token.toChar();
        numDeJogadas += 1;
        return true;
    }

    public boolean verificaGanhador() {
        // Only verify if the game can already be over with the number of moves
        if (numDeJogadas < (gridSize * 2) - 1) {
            return false;
        }

        if (verifyHorizontals() || verifyVerticals() || verifyDiagonals()) {
            return true;
        }

        return false;
    }

    private boolean verifyHorizontals() {
        for (int i = 0; i < gridSize; i++)
        {
            // If one row has all the same chars
            if (verifyRow(i)) {
                return true;
            }
        }

        return false;
    }

    private boolean verifyRow(int rowIndex) {
        int gridMiddleIndex = Math.floorDiv(gridSize, 2);

        char charToCompare = grid[rowIndex][gridMiddleIndex];

        if (charToCompare == Token.Empty.toChar()) {
            return false;
        }

        for (int j = 1; j <= gridMiddleIndex; j++) {
            char leftChar = grid[rowIndex][gridMiddleIndex - j];
            char rightChar = grid[rowIndex][gridMiddleIndex + j];

            if (leftChar != charToCompare || rightChar != charToCompare) {
                return false;
            }
        }

        // If went through the iteration and didn't returned, it means all chars are the same.
        return true;
    }

    private boolean verifyVerticals() {
        for (int j = 0; j < gridSize; j++) {
            // If one column has all the same chars
            if (verifyColumn(j)) {
                return true;
            }
        }

        return false;
    }

    private boolean verifyColumn(int columnIndex) {
        int gridMiddleIndex = Math.floorDiv(gridSize, 2);

        char charToCompare = grid[gridMiddleIndex][columnIndex];

        if (charToCompare == Token.Empty.toChar()) {
            return false;
        }

        for (int i = 1; i <= gridMiddleIndex; i++) {
            char upperChar = grid[gridMiddleIndex - i][columnIndex];
            char lowerChar = grid[gridMiddleIndex + i][columnIndex];

            if (upperChar != charToCompare || lowerChar != charToCompare) {
                return false;
            }
        }

        // If went through the iteration and didn't returned, it means all chars are the same.
        return true;
    }

    private boolean verifyDiagonals() {
        int gridMiddleIndex = Math.floorDiv(gridSize, 2);

        // If the char exactly in the middle is empty, then no diagonal can be filled
        if (grid[gridMiddleIndex][gridMiddleIndex] == Token.Empty.toChar()) {
            return false;
        }

        return verifyUpperDiagonal(gridMiddleIndex) || verifyLowerDiagonal(gridMiddleIndex);
    }

    private boolean verifyUpperDiagonal(int gridMiddleIndex) {
        char charToCompare = grid[gridMiddleIndex][gridMiddleIndex];

        for (int i = 1; i <= gridMiddleIndex; i++) {
            char upperChar = grid[gridMiddleIndex - i][gridMiddleIndex - i];
            char lowerChar = grid[gridMiddleIndex + i][gridMiddleIndex + i];

            if (upperChar != charToCompare || lowerChar != charToCompare) {
                return false;
            }
        }

        // If went through the iteration and didn't returned, it means all chars are the same.
        return true;
    }

    private boolean verifyLowerDiagonal(int gridMiddleIndex) {
        char charToCompare = grid[gridMiddleIndex][gridMiddleIndex];

        for (int i = 1; i <= gridMiddleIndex; i++) {
            char upperChar = grid[gridMiddleIndex - i][gridMiddleIndex + i];
            char lowerChar = grid[gridMiddleIndex + i][gridMiddleIndex - i];

            if (upperChar != charToCompare || lowerChar != charToCompare) {
                return false;
            }
        }

        // If went through the iteration and didn't returned, it means all chars are the same.
        return true;
    }
}
