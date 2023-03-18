package com.wordz;

public class Score {
    private final String correct;
    private Letter result = Letter.INCORRECT;

    private int position;

    public Score(String correct) {

        this.correct = correct;
    }

    public Letter letter(int position) {

        return result;
    }

    public void access( String attempt) {

        if (isCorrectLetter(position, attempt)) {
            result = Letter.CORRECT;
        }
    }

    private boolean isCorrectLetter(int position, String attempt) {
        return correct.charAt(position) == attempt.charAt(position);
    }
}
