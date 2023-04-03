package com.wordz.domain;

public class WordSelection {
    private final WordRepository wordRepository;
    private final RandomNumber random;

    public WordSelection(WordRepository wordRepository, RandomNumber random) {
        this.wordRepository = wordRepository;
        this.random = random;
    }

    public String chooseRandomWord() {

        try {
            var wordNumber = random.next(wordRepository.highestWordNumber());

            return wordRepository.fetchWordByNumber(wordNumber);
        } catch (WordRepositoryException ex) {

            throw new WordSelectionException("Could not select word", ex);
        }
    }
}
