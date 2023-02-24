package com.wordz;

public class Word {
    private final String word;

    public Word(String correctWord) {
        word = correctWord;
    }

    public Score guess(String attempt) {

        Score score = new Score(word);
         score.access(attempt);

         return score;
    }
}
