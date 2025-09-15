package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Progression {
    private static final int MIN_LENGTH_PROGRESSION = 5;
    private static final int MAX_LENGTH_PROGRESSION = 10;
    private static final int MIN_LENGTH_DIFFERENCE = 1;
    private static final int MAX_LENGTH_DIFFERENCE = 5;

    public static int getMinLengthProgression() {
        return MIN_LENGTH_PROGRESSION;
    }

    public static int getMaxLengthProgression() {
        return MAX_LENGTH_PROGRESSION;
    }

    public static int getMinLengthDifference() {
        return MIN_LENGTH_DIFFERENCE;
    }

    public static int getMaxLengthDifference() {
        return MAX_LENGTH_DIFFERENCE;
    }

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

        boolean result;

        Engine.setGameIndexEngine("5");
        Engine.setInputUserText(new Scanner(System.in));

        Engine.greeting();
        Engine.gameRules();

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int lengthProgression = Engine.randomizerNumbers(getMinLengthProgression(), getMaxLengthProgression());
            int startNumber = Engine.randomizerNumbers();
            int difference = Engine.randomizerNumbers(getMinLengthDifference(), getMaxLengthDifference());
            int missedNumber = Engine.randomizerNumbers(lengthProgression - 1);
            int[] progression = createProgression(lengthProgression, startNumber, difference);

            Engine.askQuestion(outputProgression(progression, missedNumber));
            result = Engine.checkAnswer(Engine.getScr().nextLine(), progression[missedNumber]);
            if (!result) {
                break;
            } else if (i == 2) {
                Engine.finishMessage(true);
            }
        }
        Engine.getScr().close();
    }
}
