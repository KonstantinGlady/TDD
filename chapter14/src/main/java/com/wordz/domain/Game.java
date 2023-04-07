package com.wordz.domain;

public class Game {
    private static final int MAXIMUM_NUMBER_ALLOWED_GUESSES = 5;
    private final Player player;
    private final String targetWord;
    private int attemptNumber;
    private boolean isGameOver;

    public Game(Player player, String correctWord, int attemptNumber, boolean isGameOver) {

        this.player = player;
        this.targetWord = correctWord;
        this.attemptNumber = attemptNumber;
        this.isGameOver = isGameOver;
    }

    public static Game create(Player player, String correctWord) {
        return new Game(player, correctWord, 0, false);
    }

    public static Game create(Player player, String correctWord, int attempt) {
        return new Game(player, correctWord, attempt, false);
    }

    public String getWord() {
        return targetWord;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public Player getPlayer() {
        return player;
    }

    public Score attempt(String latestGuess) {
        trackNumberOfAttempt();

        var word = new Word(targetWord);
        Score score = word.guess(latestGuess);

        if ( score.allCorrect()) {
            end();
        }

        return score;
    }

    private void trackNumberOfAttempt() {
        attemptNumber++;

        if (attemptNumber == MAXIMUM_NUMBER_ALLOWED_GUESSES) {
            end();
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void end() {
        isGameOver = true;
    }
}
