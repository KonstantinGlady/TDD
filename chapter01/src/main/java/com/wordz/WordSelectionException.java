package com.wordz;

public class WordSelectionException extends RuntimeException {
    public WordSelectionException(String message, Throwable ex) {
        super(message, ex);
    }
}
