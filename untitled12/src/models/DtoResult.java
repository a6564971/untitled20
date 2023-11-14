package models;

public class DtoResult {
    private Boolean isPalindrome;
    private Integer score;

    public DtoResult(Boolean isPalindrome, Integer score) {
        this.isPalindrome = isPalindrome;
        this.score = score;
    }

    public Boolean getPalindrome() {
        return isPalindrome;
    }

    public Integer getScore() {
        return score;
    }
}
