package com.wordz;

public class Score {
    private final String correct;
    private Letter result = Letter.INCORRECT;
    private int position;

    public Score(String correct) {

        this.correct = correct;
    }

    public Letter letter(int i) {
        return result;
    }

    public void access(int position, String attempt) {

        if (isCorrectLetter(attempt)) {
            result = Letter.CORRECT;
        }
    }

    private boolean isCorrectLetter(String attempt) {
        return correct.charAt(position) == attempt.charAt(position);
    }
}
