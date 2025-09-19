package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final int MIN_NUMBER_OF_RANGE = 1;
    private static final int MAX_NUMBER_OF_RANGE = 100;
    public static String isItPrimeNumber(int n) {
        if (n < 2) {
            return "no";
        }
        double sqrt = Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
    public static void playTheGame() {
        String ruleOfTheGame = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] questionsAndAnswers =
                new String[Engine.NUMBER_ROUND_DIMENSION][Engine.NUMBER_QA_DIMENSION];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int num = Utils.generateNumber(MIN_NUMBER_OF_RANGE, MAX_NUMBER_OF_RANGE);
            for (int j = 0; j < questionsAndAnswers[i].length; j++) {
                if (j == 0) {
                    questionsAndAnswers[i][j] = String.valueOf(num);
                } else {
                    questionsAndAnswers[i][j] = isItPrimeNumber(num);
                }
            }
        }
        Engine.play(ruleOfTheGame, questionsAndAnswers);
    }
}
