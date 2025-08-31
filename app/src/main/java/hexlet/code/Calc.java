package hexlet.code;

import java.util.Scanner;

public class Calc {
    public static void playTheGame() {
        Scanner scanner = new Scanner(System.in);
        boolean successPass = true;
        int min = 1;
        int max = 100;

        System.out.print("Welcome to the Brain Games!\n\rMay I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
}
