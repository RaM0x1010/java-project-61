package hexlet.code;

import java.util.Scanner;

public class Engine {

    private String userName;
    private String gameIndex;
    private Scanner inputUserText;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Scanner getScr() {
        return this.inputUserText;
    }

    public void greeting() {
        System.out.print("Welcome to the Brain Games!\n\rMay I have your name? ");
        this.setUserName(inputUserText.nextLine());
        System.out.println("Hello, " + this.userName + "!");
    }

    public boolean checkAnswer(String answer, int answerNumber) {
        boolean result = true;
        switch(this.gameIndex) {
            case "2":
                if (answerNumber % 2 == 0) {
                    if (answer.equals("yes")) {
                        correctAnswer();
                    } else {
                        wrongAnswer(answer);
                        finishMessage(false);
                        return false;
                    }
                } else {
                    if (answer.equals("no")) {
                        correctAnswer();
                    } else {
                        wrongAnswer(answer);
                        finishMessage(false);
                        return false;
                    }
                }
                break;
            case "3":
                System.out.println("sss");;
                break;
        }
        return result;
    }

    public void askQuestion(String expression) {
        System.out.println("Question: " + expression);
        System.out.print("Your answer: ");
    }

    public void finishMessage(boolean isSuccess) {
        if (isSuccess) {
            System.out.println("Congratulations, " + this.userName);
        } else {
            System.out.println("Let's try again, " + this.userName);
        }
    }

    public void correctAnswer() {
        System.out.println("Correct!");
    }

    public void wrongAnswer(String answer) {
        if (answer.equals("yes")) {
            System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
        } else if (answer.equals("no")) {
            System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
        }
    }

    public void gameRules() {
        switch (this.gameIndex) {
            case "2":
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                break;
            case "3":
                System.out.println("What is the result of the expression?");
                break;
        }
    }

    public Engine(String gameIndex, Scanner scr) {
        this.gameIndex = gameIndex;
        this.inputUserText = scr;
    }
}
