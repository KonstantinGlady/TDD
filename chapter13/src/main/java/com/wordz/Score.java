package com.wordz;

public class Score {
    private final String correct;
    private Letter result = Letter.INCORRECT;

    public Score(String correct) {

        this.correct = correct;
    }

    public Letter letter(int position) {

        return result;
    }

    public void access(int position, String attempt) {

        if (correct.charAt(position) == attempt.charAt(position)) {
            result = Letter.CORRECT;
        }
    }
}
