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

    public static void playTheGame(String userName) {
        Random random = new Random();
        int min = 1;
        int max = 100;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        try {
            for (int i = 0; i < 3; i++) {
                int randomNumber = random.nextInt(max - min + 1) + min;
                boolean isEven = randomNumber % 2 == 0;

                System.out.println("Question: " + randomNumber);

                String answer = scanner.nextLine();

                System.out.println("Your answer: " + answer);

                if (isEven) {
                    if (answer.equals("yes")) {
                        correctAnswer();
                    } else {
                        wrongAnswer(userName, answer);
                        break;
                    }
                } else {
                    if (answer.equals("no")) {
                        correctAnswer();
                    } else {
                        wrongAnswer(userName, answer);
                        break;
                    }
                }
            }

            System.out.println("Congratulations, " + userName + "!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
