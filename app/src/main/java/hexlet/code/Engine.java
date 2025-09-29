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
        boolean isCorrect = true;
        for (String[] questionsAnswersPair : questionsAndAnswers) {
            System.out.println("Question: " + questionsAnswersPair[QUESTION_ARRAY_INDEX]);
            System.out.print("Your answer: ");
            String userInput = inputUserText.nextLine();
            if (userInput.equals(questionsAnswersPair[ANSWER_ARRAY_INDEX])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userInput + "' is wrong answer ;(. Correct answer was '"
                        + questionsAnswersPair[ANSWER_ARRAY_INDEX] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                isCorrect = false;
                break;
            }
        }
        if (isCorrect) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
