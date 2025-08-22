package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void getUserInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        scanner.close();
    }
}
