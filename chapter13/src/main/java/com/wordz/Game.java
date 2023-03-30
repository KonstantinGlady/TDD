package com.wordz;

public class Game {
    private final Player player;
    private final String targetWord;
    private int attemptNumber;

    public Game(Player player, String targetWord, int attemptNumber, boolean b) {

        this.player = player;
        this.targetWord = targetWord;
        this.attemptNumber = attemptNumber;
    }

    public static Game create(Player player, String correctWord, int attemptNumber) {
        return new Game(player, correctWord, 0, false);
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
}
