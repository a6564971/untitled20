import interfeces.Terminal;
import models.DtoResult;
import models.User;
import persistence.UserRepository;
import persistence.UserRepositoryImpl;
import services.PalindromeServices;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {


        public static void main(String[] args) {
            UserRepository userRepository = UserRepositoryImpl.getInstance();
            PalindromeServices palindromeServices = new PalindromeServices(userRepository);

            String login;
            while (true) {
                login = Terminal.getLogin();

                while (true) {
                    String word = Terminal.getWord();
                    DtoResult dtoResult = palindromeServices.checkPalindrome(word, login);
                    if (word.equalsIgnoreCase("stop")) {
                        System.out.println("It's stop!");
                        break;
                    } else if (word.equalsIgnoreCase("table")) {
                        System.out.println("It's leaderboard");
                        palindromeServices.printLeaderBoard();
                        break;
                    } else
                        System.out.printf("Result: word %s, is palindrom %s, points: %d\n", word, dtoResult.getPalindrome(),
                                dtoResult.getScore());
                    System.out.println();
                    System.out.println(palindromeServices.getLeaderBoard(3));
                }
            }
        }
    }





