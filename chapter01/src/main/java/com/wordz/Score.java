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

    public void access(String attempt) {

        for (char current : attempt.toCharArray()) {

            if (isCorrectLetter(current)) {

                result = Letter.CORRECT;
            } else if (occuresInWord(current)) {

                result = Letter.PART_CORRECT;
            }

            position++;
        }
    }

    private boolean occuresInWord(char current) {
        return correct.contains(String.valueOf(current));
    }

    private boolean isCorrectLetter(char current) {
        return correct.charAt(position) == current;
    }
}
