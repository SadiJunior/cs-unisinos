/**
 * @author Sadi de Moura Lemes Júnior
 * RA: 1940646
 *
 * Algoritmos e Programação: Estruturas Lineares
 */

import Question1.*;
import Question2.*;

public class Main {
    public static void main(String[] args) {
        question1();
        question2();
    }

    public static void question1() {
        System.out.println("\nQuestão 1:");

        int listSize = 10;
        List list = new StaticList(listSize);

        for (int i = 0; i < listSize; i++) {
            // 0, 1 ou 2. Obtendo valores repetidos
            int element = i % 3;
            list.insert(element, i);
        }

        int element = 1;
        int contagem = list.contaElementos(element);
        System.out.println(String.format("Lista: %s", list));
        System.out.println(String.format("Contagem do elemento '%d': %d", element, contagem));
    }

    public static void question2() {
        System.out.println("\nQuestão 2:");

        String[] expressions = new String[] {
            "((A+B)",
            "A+B(",
            ")A+B(-C",
            "(A+B))-(C+D",
            "((A+B)-(C+D))", // Correta
        };

        for (String expression : expressions) {
            char[] expressionChars = expression.toCharArray();

            Stack stack = new StaticStack(expressionChars.length);

            // Populates the stack with the expression chars
            // Starts from the end to the beginning, as required by the exercise
            for (int i = expressionChars.length - 1; i >= 0; i--) {
                stack.push(expressionChars[i]);
            }

            boolean isValidExpression = Metodo2.checkBrackets(stack);

            String validityText = isValidExpression ?
                    "é válida." :
                    "não é valida.";
            System.out.println(String.format("A expressão %s %s", expression, validityText));
        }
    }
}
