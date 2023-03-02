package com.wordz;

public class WordSelection {
    private final WordRepository repository;
    private final RandomNumbers random;

    public WordSelection(WordRepository repository, RandomNumbers random) {
        this.repository = repository;
        this.random = random;
    }

    public String chooseRandomWord() {

        try {
            var wordNumber = random.next(repository.higherWordNumber());
            return repository.fetchWordByNumber(wordNumber);
        } catch (WordRepositoryException ex) {
            throw new WordSelectionException("Could not select word", ex);
        }
    }
}
