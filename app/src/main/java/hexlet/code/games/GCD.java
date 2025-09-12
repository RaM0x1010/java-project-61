package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class GCD {
    private static final int MAX_VALUE_DIVISOR = 100;

    public static int getMaxValueDivisor() {
        return GCD.MAX_VALUE_DIVISOR;
    }

    public static int calculateGCD(int a, int b) {
        int valueGCD = a;
        while (b != 0) {
            valueGCD = b;
            b = a % b;
            a = valueGCD;
        }
        return valueGCD;
    }

    public static void playTheGame() {
        boolean result;
        Engine.setGameIndexEngine("4");
        Engine.setInputUserText(new Scanner(System.in));

        Engine.greeting();
        Engine.gameRules();

        for (int i = 0; i < Engine.getNumberOfAttempts(); i++) {
            int dividend = Engine.randomizerNumbers();
            int divisor = Engine.randomizerNumbers(GCD.getMaxValueDivisor());
            int resultGCD = GCD.calculateGCD(dividend, divisor);
            Engine.askQuestion(dividend + " " + divisor);
            result = Engine.checkAnswer(Engine.getScr().nextLine(), resultGCD);
            if (!result) {
                break;
            } else if (i == 2) {
                Engine.finishMessage(true);
            }
        }
        Engine.getScr().close();
    }
}
