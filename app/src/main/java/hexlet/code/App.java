package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String gameIndex;
        Scanner scrChoseTheGame = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n\r2 - Even\n\r0 - Exit\n\rYour choice: ");
        gameIndex = scrChoseTheGame.nextLine();

        switch (gameIndex) {
            case "0":
                break;
            case "1":
                Cli.getUserInput();
                break;
            case "2":
                EvenNumbers.playTheGame(Cli.getUserInput());
                break;
            default: System.out.println("no one variable are chosen please repeat.");
        }
        scrChoseTheGame.close();
    }
}
