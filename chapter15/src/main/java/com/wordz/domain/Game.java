package com.wordz.domain;

public class Game {
    private final Player player;
    private int attempt;
    private final String word;

    public Game(Player player, String word, int attempt) {
        this.player = player;
        this.word = word;
        this.attempt = attempt;
    }

    public String getWord() {
        return word;
    }

    public int getAttemptNumber() {
        return attempt;
    }

    public Player getPlayer() {
        return player;
    }
}
