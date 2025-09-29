package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final int MIN_NUMBER_OF_RANGE = 1;
    private static final int MAX_NUMBER_OF_RANGE = 100;

    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        double sqrt = Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void playTheGame() {
        String ruleOfTheGame = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] questionsAndAnswers =
                new String[Engine.ROUNDS][Engine.NUMBER_QA_DIMENSION];
        for (String[] qa : questionsAndAnswers) {
            int num = Utils.generateNumber(MIN_NUMBER_OF_RANGE, MAX_NUMBER_OF_RANGE);
            qa[Engine.QUESTION_ARRAY_INDEX] = String.valueOf(num);
            qa[Engine.ANSWER_ARRAY_INDEX] = (isPrimeNumber(num)) ? "yes" : "no";
        }
        Engine.play(ruleOfTheGame, questionsAndAnswers);
    }
}
