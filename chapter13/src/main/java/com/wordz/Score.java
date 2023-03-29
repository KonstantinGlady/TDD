package com.wordz;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final String correct;
    private final List<Letter> result = new ArrayList<>();
    private int position;

    public Score(String correct) {

        this.correct = correct;
    }

    public Letter letter(int position) {

        return result.get(position);
    }

    public void access(String attempt) {

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

    private boolean occursInWord(char current) {
        return correct.contains(String.valueOf(current));
    }

    private boolean isCorrectLetter(char current) {
        return correct.charAt(position) == current;
    }

    public boolean allCorrect() {

        var totalCorrect = result.stream()
                .filter(letter -> letter == Letter.CORRECT)
                .count();

        return totalCorrect == result.size();
    }
}
