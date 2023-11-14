package models;

public class User {
    private String login;
    private Integer score;
    private Integer totalGames;
    private Integer attempt;

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public User() {
    }

    public User(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getScore() {
        if (this.score == null) {
            this.score = 0;
        }
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTotalGames() {
        if (this.totalGames == null) {
            this.totalGames = 0;
        }
        return totalGames;
    }

    public void setTotalGames(Integer totalGames) {
        this.totalGames = totalGames;
    }

    @Override
    public String toString() {
        return "login='" + login + '\'' + ", score=" + score + ", totalGames=" + totalGames;

    }
}
