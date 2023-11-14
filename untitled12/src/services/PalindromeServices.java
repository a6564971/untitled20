package services;

import interfeces.Terminal;
import models.DtoResult;
import models.User;
import persistence.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

public class PalindromeServices {
    User user = new User();
    private final UserRepository userRepository;

    public PalindromeServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public DtoResult checkPalindrome(String word, String login) {
        User user = Optional.ofNullable(userRepository.getUser(login))
                .orElseGet(() -> new User(login));
        Boolean isPalindrome = isPalindrome(word);
        if (isPalindrome) {
            user.setScore(user.getScore() + word.length());
        }
        user.setTotalGames(user.getTotalGames() + 1);
        userRepository.saveUser(user);
        DtoResult dtoResult = isPalindrome ?
                new DtoResult(isPalindrome, word.length())
                : new DtoResult(isPalindrome, 0);
        return dtoResult;
    }

    public List<User> getLeaderBoard(Integer top) {
        List<User> leaderUserList =
                userRepository.allUsers().stream()
                        .sorted((f1, f2) -> Long.compare(f2.getScore(), f1.getScore()))
                        .limit(top)
                        .collect(Collectors.toList());
        return leaderUserList;
    }

    public void printLeaderBoard(){
        System.out.printf("%-10s %-15s\n", "User", "Score");
        System.out.println("-----------------");
        for (User user : getLeaderBoard(3)) {
            System.out.printf("%-10s %-15d\n", user.getLogin(), user.getScore());
        }
    }

    private boolean isPalindrome(String word) {
        StringBuilder reverse = new StringBuilder(word).reverse();
        return word.equalsIgnoreCase(reverse.toString());
    }

}

