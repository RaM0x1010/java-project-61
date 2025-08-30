package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String getUserInput() {

        Scanner scrGreeting = new Scanner(System.in);

        System.out.print("What is your name? ");
        String userName = scrGreeting.nextLine();
        System.out.println("Hello, " + userName + "!");

        scrGreeting.close();

        return userName;
    }
}
