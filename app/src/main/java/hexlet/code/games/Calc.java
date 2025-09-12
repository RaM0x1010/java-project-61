package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    public static void playTheGame() {
        boolean result = true;
        int min = 1;
        int max = 100;
        int countOperations = 3;
        int resultNum = 0;
        String[] operators = {"-", "+", "*"};
        Engine.setGameIndexEngine("3");
        Engine.setInputUserText(new Scanner(System.in));
        Engine.greeting();
        Engine.gameRules();

        for (int i = 0; i < Engine.getNumberOfAttempts(); i++) {

            int magicNumberIndexOperator = (int) (Math.random() * ((max - min) + 1));
            int operandOne = (int) (Math.random() * max) + min;
            int operandTwo = (int) (Math.random() * max) + min;
            int operationIndex  = magicNumberIndexOperator % countOperations;

            switch (operationIndex) {
                case 0:
                    resultNum = operandOne - operandTwo;
                    break;
                case 1:
                    resultNum = operandOne + operandTwo;
                    break;
                case 2:
                    resultNum = operandOne * operandTwo;
                    break;
                default:
                    System.out.println("Something is gone wrong!");
            }

            Engine.askQuestion(operandOne + " " + operators[operationIndex] + " " + operandTwo);
            result = Engine.checkAnswer(Engine.getScr().nextLine(), resultNum);

            if (!result) {
                break;
            } else if (i == 2) {
                Engine.finishMessage(true);
            }
        }

        Engine.getScr().close();
    }
}
