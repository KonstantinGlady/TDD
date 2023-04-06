package com.wordz.domain;

public class Game {
    private final Player player;
    private final String targetWord;
    private int attemptNumber;

    public Game(Player player, String correctWord, int attemptNumber) {

        this.player = player;
        this.targetWord = correctWord;
        this.attemptNumber = attemptNumber;
    }

    public static Game create(Player player, String correctWord) {
        return new Game(player, correctWord, 0);
    }

    public static Game create(Player player, String correctWord, int attempt) {
        return new Game(player, correctWord, attempt);
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
        attemptNumber++;
        var target = new Word(targetWord);

        return target.guess(latestGuess);
    }
}
