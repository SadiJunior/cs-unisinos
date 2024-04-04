import java.io.*;
import java.io.IOException;

public class LabirintoFactory {
    public static Labirinto createLabirinto(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            long fileLineCount = br.lines().count();

            if (fileLineCount < 2) {
                return null;
            }

            // Opens the Streams again, because the lines() method made it go to the end
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            // The row and column count is always in the first two lines, respectively
            int rowCount = Integer.parseInt(br.readLine().trim());
            int columnCount = Integer.parseInt(br.readLine().trim());

            char[][] labirinto = new char[rowCount][columnCount];

            int row = 0;
            String line = br.readLine();
            while (line != null && row < rowCount) {
                for (int column = 0; column < columnCount; column++) {
                    labirinto[row][column] = line.charAt(column);
                }

                line = br.readLine();
                row += 1;
            }

            br.close();

            return new Labirinto(labirinto, rowCount, columnCount);
        }
        catch (FileNotFoundException e) {
            System.out.println(
                    String.format(
                            "Arquivo \"%s\" não existe.",
                            fileName));
        }
        catch (IOException e) {
            System.out.println(
                    String.format(
                            "Erro na leitura de \"%s\".",
                            fileName));
        }

        return null;
    }
}
