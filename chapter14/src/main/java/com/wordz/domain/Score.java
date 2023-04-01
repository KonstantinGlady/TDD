package com.wordz.domain;

public class Score {
    private final String correct;
    private Letter result = Letter.INCORRECT;
    private int position;

    public Score(String correctWord) {

        this.correct = correctWord;
    }

    public Letter letter(int position) {
        return result;
    }

    public void assess(String attempt) {

        if (isCorrectLetter(attempt)) {
            result = Letter.CORRECT;
        }
    }

    private boolean isCorrectLetter(String attempt) {
        return attempt.charAt(position) == correct.charAt(position);
    }
}
