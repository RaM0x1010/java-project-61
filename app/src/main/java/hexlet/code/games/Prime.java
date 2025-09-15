package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Prime {

    public static boolean isItPrimeNumber(int n) {
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
        boolean result;

        Engine.setGameIndexEngine("6");
        Engine.setInputUserText(new Scanner(System.in));

        Engine.greeting();
        Engine.gameRules();

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int num = Engine.randomizerNumbers();
            Engine.askQuestion(String.valueOf(num));
            result = Engine.checkAnswer(Engine.getScr().nextLine(), isItPrimeNumber(num));
            if (!result) {
                break;
            } else if (i == 2) {
                Engine.finishMessage(true);
            }
        }
        Engine.getScr().close();
    }
}
