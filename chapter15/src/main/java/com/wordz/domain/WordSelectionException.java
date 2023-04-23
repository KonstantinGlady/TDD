package com.wordz.domain;

public class WordSelectionException extends RuntimeException {

    public WordSelectionException(String msg, Throwable th) {
        super(msg, th);
    }
}
