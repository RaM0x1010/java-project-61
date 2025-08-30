package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenNumbers {

    public static void correctAnswer() {
        System.out.println("Correct!");
    }

    public static void wrongAnswer(String userName, String answer) {
        if (answer.equals("yes")) {
            System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
        } else if (answer.equals("no")) {
            System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
        }
        System.out.println("Let's try again, " + userName + "!");
    }

    public static String greeting(Scanner scanner) {

        return scanner.nextLine();
    }

    public static void playTheGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean successPass = true;
        int min = 1;
        int max = 100;

        System.out.print("Welcome to the Brain Games!\n\rMay I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < 3; i++) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            boolean isEven = randomNumber % 2 == 0;
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");

            String answer = scanner.nextLine();

            if (isEven) {
                if (answer.equals("yes")) {
                    correctAnswer();
                } else {
                    wrongAnswer(userName, answer);
                    successPass = false;
                    break;
                }
            } else {
                if (answer.equals("no")) {
                    correctAnswer();
                } else {
                    wrongAnswer(userName, answer);
                    successPass = false;
                    break;
                }
            }
        }
        scanner.close();
            if (successPass) {
                System.out.println("Congratulations, " + userName + "!");
            }
    }
}
