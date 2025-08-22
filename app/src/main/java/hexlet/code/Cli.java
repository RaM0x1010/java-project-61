package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void getUserInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");

        scanner.close();
    }
}
