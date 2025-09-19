package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String userNameEngine;
    private static Scanner inputUserTextEngine;
    public static final int ROUNDS = 3;
    public static final int NUMBER_ROUND_DIMENSION = 3;
    public static final int NUMBER_QA_DIMENSION = 2;

    public static void setUserName(String userName) {
        userNameEngine = userName;
    }

    public static Scanner getScr() {
        return inputUserTextEngine;
    }

    public static void setInputUserText(Scanner scr) {
        inputUserTextEngine = scr;
    }

    public static void greeting() {
        System.out.print("Welcome to the Brain Games!\n\rMay I have your name? ");
        setUserName(inputUserTextEngine.nextLine());
        System.out.println("Hello, " + userNameEngine + "!");
    }

    public static void play(String rules, String[][] questionsAndAnswers) {
        boolean result = true;
        setInputUserText(new Scanner(System.in));
        Engine.greeting();
        Engine.printRules(rules);
        for (int i = 0; i < ROUNDS; i++) {
            for (int j = 0; j < questionsAndAnswers[i].length; j++) {
                if (j == 0) {
                    askQuestion(questionsAndAnswers[i][j]);
                } else {
                    result = checkAnswer(Engine.getScr().nextLine(), questionsAndAnswers[i][j]);
                }
            }
            if (!result) {
                break;
            } else if (i == 2) {
                Engine.finishMessage(true);
                Engine.getScr().close();
            }
        }
        Engine.getScr().close();
    }

    private static void printRules(String rules) {
        System.out.println(rules);
    }

    public static boolean checkAnswer(String userInput, String correctAnswer) {
        if (userInput.equals(correctAnswer)) {
            correctAnswer();
            return true;
        } else {
            wrongAnswer(userInput, correctAnswer);
            return false;
        }
    }

    public static void askQuestion(String expression) {
        System.out.println("Question: " + expression);
        System.out.print("Your answer: ");
    }

    public static void finishMessage(boolean isSuccess) {
        if (isSuccess) {
            System.out.println("Congratulations, " + userNameEngine + "!");
        } else {
            System.out.println("Let's try again, " + userNameEngine + "!");
        }
    }

    public static void correctAnswer() {
        System.out.println("Correct!");
    }

    public static void wrongAnswer(String answer, String answerNum) {
        System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + answerNum + "'.");
        finishMessage(false);
    }
}
