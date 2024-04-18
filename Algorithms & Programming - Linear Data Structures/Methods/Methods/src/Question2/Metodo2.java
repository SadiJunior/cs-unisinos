package Question2;

public class Metodo2 {
    public static boolean checkBrackets(Stack<Character> s1) {
        int bracketIndicator = 0;

        while (!s1.isEmpty()) {
            Character element = s1.pop();

            if (element == '(') {
                bracketIndicator += 1;
            }
            else if (element == ')') {
                bracketIndicator -= 1;
            }

            // Se em algum momento existiu um ')' a mais, quer dizer que est� errado
            if (bracketIndicator < 0) {
                return false;
            };
        }

        // O n�mero de '(' deve anular o n�mero de ')'.
        return bracketIndicator == 0;
    }
}
