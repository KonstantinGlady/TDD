package com.wordz.domain;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final String correct;
    private List<Letter> result = new ArrayList<>();
    private int position;

    public Score(String correctWord) {

        this.correct = correctWord;
    }

    public Letter letter(int position) {
        return result.get(position);
    }

    public void assess(String attempt) {

        for (char current : attempt.toCharArray()) {

            if (isCorrectLetter(current)) {

                result.add(Letter.CORRECT);
            } else if (occursInWord(current)) {

                result.add(Letter.PART_CORRECT);
            } else {
                result.add(Letter.INCORRECT);
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
