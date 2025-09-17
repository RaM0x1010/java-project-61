package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 3;

    public static void playTheGame() {
        boolean result = true;
        int resultNum = 0;
        String[] operators = {"-", "+", "*"};
        Engine.setGameIndexEngine("3");
        Engine.setInputUserText(new Scanner(System.in));
        Engine.greeting();
        Engine.gameRules();

        for (int i = 0; i < Engine.ROUNDS; i++) {

            int operandOne = Engine.randomizerNumbers();
            int operandTwo = Engine.randomizerNumbers();
            int operationIndex  = Engine.randomizerNumbers(
                    MIN_RANDOM_VALUE, MAX_RANDOM_VALUE) % MAX_RANDOM_VALUE;

            switch (operationIndex) {
                case 0:
                    resultNum = operandOne - operandTwo;
                    break;
                case 1:
                    resultNum = operandOne + operandTwo;
                    break;
                case 2:
                    resultNum = operandOne * operandTwo;
                    break;
                default:
                    System.out.println("Something is gone wrong!");
            }

            Engine.askQuestion(operandOne + " " + operators[operationIndex] + " " + operandTwo);
            result = Engine.checkAnswer(Engine.getScr().nextLine(), resultNum);

            if (!result) {
                break;
            } else if (i == 2) {
                Engine.finishMessage(true);
            }
        }

        Engine.getScr().close();
    }
}
