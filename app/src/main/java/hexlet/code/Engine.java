package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int ROUNDS = 3;
    public static final int NUMBER_QA_DIMENSION = 2;
    public static final int QUESTION_ARRAY_INDEX = 0;
    public static final int ANSWER_ARRAY_INDEX = 1;

    public static void play(String rules, String[][] questionsAndAnswers) {
        Scanner inputUserText = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\n\rMay I have your name? ");
        String userName = inputUserText.nextLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println(rules);
        for (String[] questionsAnswersPair : questionsAndAnswers) {
            boolean isCorrect = true;
            int qaIndex = 0;
            for (String qa : questionsAnswersPair) {
                if (qaIndex == 0) {
                    System.out.println("Question: " + qa);
                    System.out.print("Your answer: ");
                } else {
                    isCorrect = checkAnswer(inputUserText.nextLine(), qa, userName);
                }
                qaIndex++;
            }
            if (!isCorrect) {
                break;
            } else if (qaIndex == questionsAndAnswers.length - 1) {
                System.out.println("Congratulations, " + userName + "!");
            }
        }
    }

    public static boolean checkAnswer(String userInput, String correctAnswer, String userName) {
        if (userInput.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("'" + userInput + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + userName + "!");
            return false;
        }
    }
}
