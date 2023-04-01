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

        for (char current : attempt.toCharArray()) {

            if (isCorrectLetter(current)) {

                result = Letter.CORRECT;
            } else if (occursInWord(current)) {

                result = Letter.PART_CORRECT;
            }

            position++;
        }
    }

    private boolean occursInWord(char currentLetter) {
        return correct.contains(String.valueOf(currentLetter));
    }

    private boolean isCorrectLetter(char currentChar) {
        return correct.charAt(position) == currentChar;
    }
}
