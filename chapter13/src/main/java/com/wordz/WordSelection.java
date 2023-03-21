package com.wordz;

public class WordSelection {
    private final WordRepository wordRepository;
    private final RandomNumbers random;

    public WordSelection(WordRepository wordRepository, RandomNumbers random) {
        this.wordRepository = wordRepository;
        this.random = random;
    }

    public String choseRandomWord() {
        var wordNumber = random.next(wordRepository.highestWordNumber());

        return wordRepository.fetchWordByNumber(wordNumber);
    }
}
