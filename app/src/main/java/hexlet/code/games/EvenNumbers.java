package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class EvenNumbers {

    public static void playTheGame() {
        boolean result;
        int min = 1;
        int max = 100;
        Engine.setGameIndexEngine("2");
        Engine.setInputUserText(new Scanner(System.in));

        Engine.greeting();
        Engine.gameRules();

        for (int i = 0; i < 3; i++) {
            int randomNumber = (int) (Math.random() * max) + min;
            Engine.askQuestion(String.valueOf(randomNumber));
            result = Engine.checkAnswer(Engine.getScr().nextLine(), randomNumber);
            if (!result) {
                break;
            } else if (i == 2) {
                Engine.finishMessage(true);
            }
        }
        Engine.getScr().close();
    }
}
