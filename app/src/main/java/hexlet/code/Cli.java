package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void getUserInput() {

        Scanner scrGreeting = new Scanner(System.in);

        System.out.print("Welcome to the Brain Games!\n\rMay I have your name? ");
        String userName = scrGreeting.nextLine();
        System.out.println("Hello, " + userName + "!");

        scrGreeting.close();
    }
}
