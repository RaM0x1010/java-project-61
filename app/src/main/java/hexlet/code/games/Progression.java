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

    public static String[] createProgression(int startNum, int diffNum, int progressionLength) {
        String[] progression = new String[progressionLength];
        for (int i = 0; i < progression.length; i++) {
            progression[i] = String.valueOf(startNum + i * diffNum);
        }
        return progression;
    }

    public static void playTheGame() {
        String ruleOfTheGame = "What number is missing in the progression?";
        String[][] questionsAndAnswers =
                new String[Engine.ROUNDS][Engine.NUMBER_QA_DIMENSION];
        for (String[] qa : questionsAndAnswers) {
            int startNumber = Utils.generateNumber(MIN_START_NUM, MAX_START_NUM);
            int difference = Utils.generateNumber(MIN_LENGTH_DIFFERENCE, MAX_LENGTH_DIFFERENCE);
            int lengthProgression = Utils.generateNumber(MIN_LENGTH_PROGRESSION, MAX_LENGTH_PROGRESSION);
            int missedNumber = Utils.generateNumber(MIN_INDEX_MISSED_NUM, lengthProgression - 1);
            String[] progression = createProgression(startNumber, difference, lengthProgression);
            String answer = progression[missedNumber];
            progression[missedNumber] = "..";
            qa[Engine.QUESTION_ARRAY_INDEX] = String.join(" ", progression);
            qa[Engine.ANSWER_ARRAY_INDEX] = answer;
        }
        Engine.play(ruleOfTheGame, questionsAndAnswers);
    }
}
