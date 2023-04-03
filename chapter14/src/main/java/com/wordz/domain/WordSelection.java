package com.wordz.domain;

public class WordSelection {
    public WordSelection(WordRepository wordRepository, RandomNumber random) {
    }

    public String getRandomWord() throws WordSelectionException {
        throw new WordSelectionException();
    }
}
