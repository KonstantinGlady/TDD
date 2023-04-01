package com.wordz.domain;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final String correct;
    private final List<Letter> result = new ArrayList<>();
    private int position;

    public Score(String correctWord) {

        this.correct = correctWord;
    }

    public Letter letter(int position) {
        return result.get(position);
    }

    public void assess(String attempt) {

        for (char current : attempt.toCharArray()) {

            result.add(scoreFor(current));

            position++;
        }
    }

    private Letter scoreFor(char current) {

        if (isCorrectLetter(current)) {
            return Letter.CORRECT;
        }

        if (occursInWord(current)) {
            return Letter.PART_CORRECT;
        }

        return Letter.INCORRECT;
    }

    private boolean occursInWord(char currentLetter) {
        return correct.contains(String.valueOf(currentLetter));
    }

    private boolean isCorrectLetter(char currentChar) {
        return correct.charAt(position) == currentChar;
    }
}
