/**
 * Essa classe centraliza métodos para printar Arrays.
 *
 * @author Sadi de Moura Lemes Júnior
 */
public class ArrayPrinter
{
    /**
     * Converte um array para uma String.
     *
     * @param array O array para ser convertido para String.
     * @return Uma String do array.
     */
    public static String arrayToString(int[] array)
    {
        StringBuilder arraySB = new StringBuilder();

        for (int j = 0; j < array.length; j++)
        {
            arraySB.append(array[j]);

            // Adiciona vírgulas entre os items (menos no último elemento).
            if (j == array.length - 1)
            {
                arraySB.append(".");

            }
            else
            {
                arraySB.append(", ");
            }
        }

        arraySB.append(System.lineSeparator());

        return arraySB.toString();
    }
}
