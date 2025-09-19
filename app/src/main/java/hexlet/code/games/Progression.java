package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final int MIN_LENGTH_PROGRESSION = 5;
    private static final int MAX_LENGTH_PROGRESSION = 10;
    private static final int MIN_LENGTH_DIFFERENCE = 1;
    private static final int MAX_LENGTH_DIFFERENCE = 5;
    private static final int MIN_START_NUM = 1;
    private static final int MAX_START_NUM = 100;
    private static final int MIN_INDEX_MISSED_NUM = 0;

    public static String outputProgression(int[] arrToStr, int indexOfMissedNumber) {

        StringBuilder prepareStringProgression = new StringBuilder();

        for (int i = 0; i < arrToStr.length; i++) {
            if (i != indexOfMissedNumber) {
                prepareStringProgression.append(arrToStr[i]);
            } else {
                prepareStringProgression.append("..");
            }
            if (i != arrToStr.length - 1) {
                prepareStringProgression.append(" ");
            }
        }
        return prepareStringProgression.toString();
    }

    public static int[] createProgression(int maxL, int startN, int diffStep) {
        int[] progressionArray = new int[maxL];
        for (int i = 0; i < progressionArray.length; i++) {
            progressionArray[i] = startN + i * diffStep;
        }
        return progressionArray;
    }

    public static void playTheGame() {
        String ruleOfTheGame = "What number is missing in the progression?";
        String[][] questionsAndAnswers =
                new String[Engine.NUMBER_ROUND_DIMENSION][Engine.NUMBER_QA_DIMENSION];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int lengthProgression = Utils.generateNumber(MIN_LENGTH_PROGRESSION, MAX_LENGTH_PROGRESSION);
            int startNumber = Utils.generateNumber(MIN_START_NUM, MAX_START_NUM);
            int difference = Utils.generateNumber(MIN_LENGTH_DIFFERENCE, MAX_LENGTH_DIFFERENCE);
            int missedNumber = Utils.generateNumber(MIN_INDEX_MISSED_NUM, lengthProgression - 1);
            int[] progression = createProgression(lengthProgression, startNumber, difference);
            for (int j = 0; j < questionsAndAnswers[i].length; j++) {
                if (j == 0) {
                    questionsAndAnswers[i][j] = outputProgression(progression, missedNumber);
                } else {
                    questionsAndAnswers[i][j] = String.valueOf(progression[missedNumber]);
                }
            }
        }
        Engine.play(ruleOfTheGame, questionsAndAnswers);
    }
}
