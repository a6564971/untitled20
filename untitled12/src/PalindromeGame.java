import java.util.*;

public class PalindromeGame {

    //Здесь мы храним результаты и таблицу лидеров
    public Map<String, Integer> scores = new HashMap<>();
    public List<String> leaderboard = new ArrayList<>();

    //Здесь мы проверяем является ли слово палиндромом
    public boolean isPalindrome(String word) {
        StringBuilder reverse = new StringBuilder(word).reverse();
        return word.equalsIgnoreCase(reverse.toString());
    }
    //Здесь мы принимаем пользователя и его слово, проверяем слово на палиндром
    // и обновляем оценку пользователя и обновляем таблицу лидеров, сортируя их по их баллам
    public void submitWord(String word, String user) {
        if (isPalindrome(word)) {
            if (!scores.containsKey(user)) {
                scores.put(user, 0);
            }
            if (!leaderboard.contains(user)) {
                int score = (scores.get(user) + word.length());
                scores.put(user, score);
                updateLeaderboard(user);

                // Здесь можно добавить интеграцию базы данных
            }
        }
    }
    public void updateLeaderboard(String user) {
        leaderboard.add(user);
        leaderboard.sort((u1, u2) -> scores.get(u2) - scores.get(u1));
        if (leaderboard.size() > 5){
            leaderboard.remove(5);
        }
    }
    //Возвращаем текущую таблицу лидеров
    List<String> getLeaderboard() {
        return leaderboard;
    }
}
