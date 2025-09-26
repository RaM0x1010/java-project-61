package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenNumbers {
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 100;

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void playTheGame() {
        String ruleOfTheGame = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] questionsAndAnswers =
                new String[Engine.ROUNDS][Engine.NUMBER_QA_DIMENSION];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int randomNumber = Utils.generateNumber(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
            questionsAndAnswers[i][Engine.QUESTION_ARRAY_INDEX] = String.valueOf(randomNumber);
            questionsAndAnswers[i][Engine.ANSWER_ARRAY_INDEX] = (isEven(randomNumber)) ? "yes" : "no";
        }
        Engine.play(ruleOfTheGame, questionsAndAnswers);
    }
}
