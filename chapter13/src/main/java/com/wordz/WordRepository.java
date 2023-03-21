package com.wordz;

public interface WordRepository {
    int highestWordNumber();

    String fetchWordByNumber(int number);
}
