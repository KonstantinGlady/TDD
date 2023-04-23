package com.wordz.domain;

public class WordSelection {
    private final WordRepository repository;
    private final RandomNumber random;

    public WordSelection(WordRepository repository, RandomNumber random) {
        this.repository = repository;
        this.random = random;
    }

    public String choseRandomWord() {

        try {
            var wordNumber = repository.highestWordNumber();

            return repository.fetchWordByNumber(random.next(wordNumber));
        } catch (WordRepositoryException ex) {

            throw new WordSelectionException("Couldn't find word", ex);
        }
    }
}
