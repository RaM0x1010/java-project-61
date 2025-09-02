package hexlet.code.games;

import java.util.Scanner;

public class Calc {
    public static void playTheGame() {
        Scanner scanner = new Scanner(System.in);
        boolean successPass = true;
        int min = 1;
        int max = 100;
        int countOperations = 3;
        int result = 0;
        String[] operators = {"-", "+", "*"};

        System.out.print("Welcome to the Brain Games!\n\rMay I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println("What is the result of the expression?");

        for (int i = 0; i < 3; i++) {

            int magicNumberIndexOperator = (int) (Math.random() * ((max - min) + 1));
            int operandOne = (int) (Math.random() * max) + min;
            int operandTwo = (int) (Math.random() * max) + min;
            int operationIndex  = magicNumberIndexOperator % countOperations;

            switch (operationIndex) {
                case 0:
                    result = operandOne - operandTwo;
                    break;
                case 1:
                    result = operandOne + operandTwo;
                    break;
                case 2:
                    result = operandOne * operandTwo;
                    break;
                default:
                    System.out.println("no case for that");
            }

            System.out.println("Question: " + operandOne + " " + operators[operationIndex] + " " + operandTwo);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (answer.equals(String.valueOf(result))) {
                System.out.println("Correct!");
            } else {
                successPass = false;
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + result + "'.");
                System.out.println("Let's try again, " + userName);
                break;
            }


        }

        scanner.close();
        if (successPass) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
