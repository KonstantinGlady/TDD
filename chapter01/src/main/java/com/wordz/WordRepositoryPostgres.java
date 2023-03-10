package com.wordz;

public class WordRepositoryPostgres implements WordRepository {
    @Override
    public String fetchWordByNumber(int number) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public int highestWordNumber() {
        throw new UnsupportedOperationException("not implemented");
    }
}
