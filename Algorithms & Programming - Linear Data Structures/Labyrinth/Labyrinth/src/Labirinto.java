public class Labirinto {
    private char[][] labirinto;
    private int rowCount;
    private int columnCount;

    public Labirinto(char[][] labirinto, int rowCount, int columnCount) {
        this.labirinto = labirinto;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    public char[][] getLabirinto() {
        return labirinto;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public boolean resolveLabirinto() {
        // Clones the labyrinth array for not changing the original one
        char[][] labirinto = this.labirinto.clone();

        // Starts from the starting point (0, 0)
        return resolveLabirinto(labirinto, 0, 0);
    }

    private boolean resolveLabirinto(char[][] labirinto, int row, int column) {
        // If got to the limits
        if (row < 0 || column < 0 || row >= rowCount || column >= columnCount) {
            return false;
        }

        boolean isBlocked = labirinto[row][column] == 'X';
        if (isBlocked) {
            return false;
        }

        boolean wasAlreadyHere = labirinto[row][column] == 'p';
        if (wasAlreadyHere) {
            return false;
        }

        boolean foundExit = labirinto[row][column] == 'D';
        if (foundExit) {
            return true;
        }

        // Marks the path for not entering in circular loops
        labirinto[row][column] = 'p';

        // Go recursively to all sides
        boolean upperPath = resolveLabirinto(labirinto, row - 1, column);
        boolean lowerPath = resolveLabirinto(labirinto, row + 1, column);
        boolean leftPath = resolveLabirinto(labirinto, row, column - 1);
        boolean rightPath = resolveLabirinto(labirinto, row, column + 1);

        // Tries going everywhere every time
        return upperPath || lowerPath || leftPath || rightPath;
    }
}
