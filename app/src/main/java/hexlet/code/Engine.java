package hexlet.code;

import java.security.SecureRandom;
import java.util.Scanner;


public class Engine {

    private static final SecureRandom RANDOMIZED_OBJ = new SecureRandom();
    private static String userNameEngine;
    private static String gameIndexEngine;
    private static Scanner inputUserTextEngine;
    public static final int ROUNDS = 3;
    public static final int MIN_NUMBER_OF_RANGE = 1;
    public static final int MAX_NUMBER_OF_RANGE = 100;

    public static void setUserName(String userName) {
        Engine.userNameEngine = userName;
    }

    public static Scanner getScr() {
        return inputUserTextEngine;
    }

    public static void setGameIndexEngine(String gameIndex) {
        gameIndexEngine = gameIndex;
    }

    public static void greeting() {
        System.out.print("Welcome to the Brain Games!\n\rMay I have your name? ");
        setUserName(inputUserTextEngine.nextLine());
        System.out.println("Hello, " + userNameEngine + "!");
    }

    public static boolean checkAnswer(String answer, int answerNumber) {
        if (answer.equals(String.valueOf(answerNumber))) {
            correctAnswer();
            return true;
        } else {
            wrongAnswer(answer, answerNumber);
            return false;
        }
    }

    public static boolean checkAnswer(String answer, boolean correctAnswer) {
        if (correctAnswer) {
            if (answer.equals("yes")) {
                correctAnswer();
                return true;
            } else {
                wrongAnswer(answer);
                return false;
            }
        } else {
            if (answer.equals("no")) {
                correctAnswer();
                return true;
            } else {
                wrongAnswer(answer);
                return false;
            }
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

    public static void wrongAnswer(String answer) {
        if (answer.equals("yes")) {
            System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
        } else if (answer.equals("no")) {
            System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
        }
        finishMessage(false);
    }

    public static void wrongAnswer(String answer, int answerNum) {
        System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + answerNum + "'.");
        finishMessage(false);
    }

    public static void gameRules() {
        switch (gameIndexEngine) {
            case "2":
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                break;
            case "3":
                System.out.println("What is the result of the expression?");
                break;
            case "4":
                System.out.println("Find the greatest common divisor of given numbers.");
                break;
            case "5":
                System.out.println("What number is missing in the progression?");
                break;
            case "6":
                System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
                break;
            default:
                System.out.println("Something is gone wrong!");
        }
    }

    public static void setInputUserText(Scanner scr) {
        inputUserTextEngine = scr;
    }

    public static int randomizerNumbers() {
        return RANDOMIZED_OBJ.nextInt(MIN_NUMBER_OF_RANGE, MAX_NUMBER_OF_RANGE);
    }

    public static int randomizerNumbers(int max) {
        return RANDOMIZED_OBJ.nextInt(max);
    }

    public static int randomizerNumbers(int min, int max) {
        return RANDOMIZED_OBJ.nextInt(min, max);
    }
}
