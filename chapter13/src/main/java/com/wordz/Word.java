package com.wordz;

import java.io.StreamCorruptedException;

public class Word {
    private final String word;

    public Word(String correctWord) {
        word = correctWord;
    }

    public Score guess(String attempt) {

        var score = new Score(word);

        score.access(0, attempt);

        return score;
    }
}
