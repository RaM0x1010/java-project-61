package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenNumbers {
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 100;

    public static String isItEven(int num) {
        return ((num % 2 == 0) ? "yes" : "no");
    }

    public static void playTheGame() {
        String ruleOfTheGame = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] questionsAndAnswers =
                new String[Engine.NUMBER_ROUND_DIMENSION][Engine.NUMBER_QA_DIMENSION];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int randomNumber = Utils.generateNumber(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
            for (int j = 0; j < questionsAndAnswers[i].length; j++) {
                if (j == 0) {
                    questionsAndAnswers[i][j] = String.valueOf(randomNumber);
                } else {
                    questionsAndAnswers[i][j] = isItEven(randomNumber);
                }
            }
        }
        Engine.play(ruleOfTheGame, questionsAndAnswers);
    }
}
