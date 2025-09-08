package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.EvenNumbers;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scrChoseTheGame = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.print("""
                1 - Greet
                \r\
                2 - Even
                \r\
                3 - Calc
                \r\
                0 - Exit
                \r\
                Your choice:\s""");
        String gameIndex = scrChoseTheGame.nextLine();

        switch (gameIndex) {
            case "0":
                break;
            case "1":
                Cli.getUserInput();
                break;
            case "2":
                EvenNumbers.playTheGame();
                break;
            case "3":
                Calc.playTheGame();
                break;
            default: System.out.println("no one variable are chosen please repeat.");
        }
        scrChoseTheGame.close();
    }
}
