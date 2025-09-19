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
                new String[Engine.NUMBER_ROUND_DIMENSION][Engine.NUMBER_QA_DIMENSION];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int dividend = Utils.generateNumber(MIN_VALUE_DIVIDEND, MAX_VALUE_DIVIDEND);
            int divisor = Utils.generateNumber(MIN_VALUE_DIVISOR, MAX_VALUE_DIVISOR);
            int resultGCD = GCD.calculateGCD(dividend, divisor);
            for (int j = 0; j < questionsAndAnswers[i].length; j++) {
                if (j == 0) {
                    questionsAndAnswers[i][j] = dividend + " " + divisor;
                } else {
                    questionsAndAnswers[i][j] = String.valueOf(resultGCD);
                }
            }
        }
        Engine.play(ruleOfTheGame, questionsAndAnswers);
    }
}
