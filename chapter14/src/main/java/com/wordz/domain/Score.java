package com.wordz.domain;

public class Score {
    private final String correct;
    private Letter result = Letter.INCORRECT;

    public Score(String correctWord) {

        this.correct = correctWord;
    }

    public Letter letter(int position) {
        return result;
    }

    public void assess(int position, String attempt) {

        if (attempt.charAt(position) == correct.charAt(position)) {
            result = Letter.CORRECT;
        }
    }
}
