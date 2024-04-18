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

            // Se em algum momento existiu um ')' a mais, quer dizer que está errado
            if (bracketIndicator < 0) {
                return false;
            };
        }

        // O número de '(' deve anular o número de ')'.
        return bracketIndicator == 0;
    }
}
