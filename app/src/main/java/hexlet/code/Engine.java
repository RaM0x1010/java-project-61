package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static String userNameEngine;
    private static String gameIndexEngine;
    private static Scanner inputUserTextEngine;

    public static void setUserName(String userName) {
        Engine.userNameEngine = userName;
    }

    public static Scanner getScr() {
        return Engine.inputUserTextEngine;
    }

    public static void greeting() {
        System.out.print("Welcome to the Brain Games!\n\rMay I have your name? ");
        Engine.setUserName(Engine.inputUserTextEngine.nextLine());
        System.out.println("Hello, " + Engine.userNameEngine + "!");
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
            System.out.println("Congratulations, " + Engine.userNameEngine + "!");
        } else {
            System.out.println("Let's try again, " + Engine.userNameEngine + "!");
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
        Engine.finishMessage(false);
    }

    public static void wrongAnswer(String answer, int answerNum) {
        System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + answerNum + "'.");
        Engine.finishMessage(false);
    }

    public static void gameRules() {
        switch (Engine.gameIndexEngine) {
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
    public static void setGameIndexEngine(String gameIndex) {
        Engine.gameIndexEngine = gameIndex;
    }

    public static void setInputUserText(Scanner scr) {
        Engine.inputUserTextEngine = scr;
    }

    public static int randomizerNumbers() {
        int min = 1;
        int max = 100;
        return (int) (Math.random() * max) + min;
    }

    public static int randomizerNumbers(int max) {
        return (int) (Math.random() * (max + 1));
    }

    public static int randomizerNumbers(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
