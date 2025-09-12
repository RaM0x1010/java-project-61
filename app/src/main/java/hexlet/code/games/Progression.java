package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Progression {
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
        int MIN_LENGTH_PROGRESSION = 5;
        int MAX_LENGTH_PROGRESSION = 10;
        int MIN_LENGTH_DIFFERENCE = 1;
        int MAX_LENGTH_DIFFERENCE = 5;
        boolean result;

        Engine.setGameIndexEngine("5");
        Engine.setInputUserText(new Scanner(System.in));

        Engine.greeting();
        Engine.gameRules();

        for (int i = 0; i < Engine.getNumberOfAttempts(); i++) {
            int lengthProgression = Engine.randomizerNumbers(MIN_LENGTH_PROGRESSION, MAX_LENGTH_PROGRESSION);
            int startNumber = Engine.randomizerNumbers();
            int difference = Engine.randomizerNumbers(MIN_LENGTH_DIFFERENCE, MAX_LENGTH_DIFFERENCE);
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
