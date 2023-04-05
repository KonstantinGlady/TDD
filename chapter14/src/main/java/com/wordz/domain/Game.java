package com.wordz.domain;

public class Game {
    private final Player player;
    private final String correct;
    private int attempt;

    public Game(Player player, String correctWord, int attempt) {

        this.player = player;
        this.correct = correctWord;
        this.attempt = attempt;
    }

    public static Game create(Player player, String correctWord) {
        return new Game(player, correctWord, 0);
    }

    public String getWord() {
        return correct;
    }

    public int getAttemptNumber() {
        return attempt;
    }

    public Player getPlayer() {
        return player;
    }
}
