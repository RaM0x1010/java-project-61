package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class EvenNumbers {

    public static void playTheGame() {

        boolean result = true;
        int min = 1;
        int max = 100;
        Engine en = new Engine("2", new Scanner(System.in));

        en.greeting();
        en.gameRules();

        for (int i = 0; i < 3; i++) {
            int randomNumber = (int) (Math.random() * max) + min;
            en.askQuestion(String.valueOf(randomNumber));//            System.out.println("Question: " + randomNumber);
            result = en.checkAnswer(en.getScr().nextLine(), randomNumber);
            if (!result) {
                break;
            }
        }

        en.finishMessage(result);
        en.getScr().close();
    }
}
