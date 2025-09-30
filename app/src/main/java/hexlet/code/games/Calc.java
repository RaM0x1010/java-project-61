package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 3;
    private static final int MIN_NUMBER_OF_RANGE = 1;
    private static final int MAX_NUMBER_OF_RANGE = 100;

    public static int calculateExpression(int index, int firstNum, int secondNum) {
        switch (index) {
            case 0:
                return firstNum - secondNum;
            case 1:
                return firstNum + secondNum;
            case 2:
                return firstNum * secondNum;
            default:
                throw new RuntimeException("Unknown operator: " + index);
        }
    }

    public static void playTheGame() {
        String ruleOfTheGame = "What is the result of the expression?";
        String[] operators = {"-", "+", "*"};
        String[][] questionsAndAnswers =
                new String[Engine.ROUNDS][Engine.NUMBER_QA_DIMENSION];
        for (String[] qa : questionsAndAnswers) {
            int operandOne = Utils.generateNumber(MIN_NUMBER_OF_RANGE, MAX_NUMBER_OF_RANGE);
            int operandTwo = Utils.generateNumber(MIN_NUMBER_OF_RANGE, MAX_NUMBER_OF_RANGE);
            int operationIndex  = Utils.generateNumber(
                    MIN_RANDOM_VALUE, MAX_RANDOM_VALUE) % MAX_RANDOM_VALUE;
            qa[Engine.QUESTION_ARRAY_INDEX] =
                    operandOne + " " + operators[operationIndex] + " " + operandTwo;
            qa[Engine.ANSWER_ARRAY_INDEX] =
                    String.valueOf(calculateExpression(operationIndex, operandOne, operandTwo));
        }
        Engine.play(ruleOfTheGame, questionsAndAnswers);
    }
}
