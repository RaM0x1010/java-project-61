package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final int MIN_VALUE_DIVISOR = 1;
    private static final int MIN_VALUE_DIVIDEND = 0;
    private static final int MAX_VALUE_DIVIDEND = 99;
    private static final int MAX_VALUE_DIVISOR = 99;

    public static int calculateGCD(int a, int b) {
        int valueGCD = a;
        while (b != 0) {
            valueGCD = b;
            b = a % b;
            a = valueGCD;
        }
        return valueGCD;
    }

    public static void playTheGame() {
        String ruleOfTheGame = "Find the greatest common divisor of given numbers.";
        String[][] questionsAndAnswers =
                new String[Engine.ROUNDS][Engine.NUMBER_QA_DIMENSION];
        for (String[] qa : questionsAndAnswers) {
            int dividend = Utils.generateNumber(MIN_VALUE_DIVIDEND, MAX_VALUE_DIVIDEND);
            int divisor = Utils.generateNumber(MIN_VALUE_DIVISOR, MAX_VALUE_DIVISOR);
            int resultGCD = GCD.calculateGCD(dividend, divisor);
            qa[Engine.QUESTION_ARRAY_INDEX] = dividend + " " + divisor;
            qa[Engine.ANSWER_ARRAY_INDEX] = String.valueOf(resultGCD);
        }
        Engine.play(ruleOfTheGame, questionsAndAnswers);
    }
}
