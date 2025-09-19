package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 3;
    private static final int MIN_NUMBER_OF_RANGE = 1;
    private static final int MAX_NUMBER_OF_RANGE = 100;

    public static void playTheGame() {
        String ruleOfTheGame = "What is the result of the expression?";
        int resultNum = 0;
        String[] operators = {"-", "+", "*"};
        String[][] questionsAndAnswers =
                new String[Engine.NUMBER_ROUND_DIMENSION][Engine.NUMBER_QA_DIMENSION];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int operandOne = Utils.generateNumber(MIN_NUMBER_OF_RANGE, MAX_NUMBER_OF_RANGE);
            int operandTwo = Utils.generateNumber(MIN_NUMBER_OF_RANGE, MAX_NUMBER_OF_RANGE);
            int operationIndex  = Utils.generateNumber(
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

            for (int j = 0; j < questionsAndAnswers[i].length; j++) {
                if (j == 0) {
                    questionsAndAnswers[i][j] = operandOne + " " + operators[operationIndex] + " " + operandTwo;
                } else {
                    questionsAndAnswers[i][j] = String.valueOf(resultNum);
                }
            }
        }
        Engine.play(ruleOfTheGame, questionsAndAnswers);
    }
}
