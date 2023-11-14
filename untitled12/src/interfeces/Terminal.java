package interfeces;

import persistence.UserRepository;
import services.PalindromeServices;

import java.util.Scanner;

public class Terminal {


    public static String getLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert login: ");
        String login = scanner.nextLine();
        return login;

    }

    public static String getWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert palindrom: ");
        String palindrome = scanner.nextLine();
        return palindrome;
    }

    private Terminal() {
        throw new RuntimeException("utility class");
    }
}
