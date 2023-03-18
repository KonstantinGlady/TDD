package com.wordz;

public class Word {
    private final String word;

    public Word(String correctWord) {
        word = correctWord;
    }

    public Score guess(String attempt) {

        var score = new Score(word);

        score.access(attempt);

        return score;
    }
}
