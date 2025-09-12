package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class EvenNumbers {

    public static boolean isItEven(int num) {
        return num % 2 == 0;
    }

    public static void playTheGame() {
        boolean result;
        Engine.setGameIndexEngine("2");
        Engine.setInputUserText(new Scanner(System.in));

        Engine.greeting();
        Engine.gameRules();

        for (int i = 0; i < 3; i++) {
            int randomNumber = Engine.randomizerNumbers();
            Engine.askQuestion(String.valueOf(randomNumber));
            result = Engine.checkAnswer(Engine.getScr().nextLine(), isItEven(randomNumber));
            if (!result) {
                break;
            } else if (i == 2) {
                Engine.finishMessage(true);
            }
        }
        Engine.getScr().close();
    }
}
