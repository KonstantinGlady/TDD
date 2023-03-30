package com.wordz;

public class Game {
    private static final int MAX_NUMBER_ALLOWED_GUESSES = 5;
    private final Player player;
    private final String targetWord;
    private int attemptNumber;
    private final boolean isGameOver;

    public Game(Player player, String targetWord, int attemptNumber, boolean isGameOver) {

        this.player = player;
        this.targetWord = targetWord;
        this.attemptNumber = attemptNumber;
        this.isGameOver = isGameOver;
    }

    public static Game create(Player player, String correctWord, int attemptNumber) {
        return new Game(player, correctWord, attemptNumber, false);
    }

    public String getTargetWord() {
        return targetWord;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public Player getPlayer() {
        return player;
    }

    public void incrementAttemptNumber() {
        attemptNumber++;
    }

    public Score attempt(String lastGuess) {
        attemptNumber++;
        var target = new Word(targetWord);

        return target.guess(lastGuess);
    }

    public boolean hasNoRemainingGuesses() {
        return attemptNumber == MAX_NUMBER_ALLOWED_GUESSES;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
