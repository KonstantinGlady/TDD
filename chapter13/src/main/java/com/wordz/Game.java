package com.wordz;

public class Game {
    private final Player player;
    private final String word;
    private final int attempt;

    public Game(Player player, String word, int attempt) {

        this.player = player;
        this.word = word;
        this.attempt = attempt;
    }

    public String getWord() {
        return word;
    }

    public int getAttemptNumbers() {
        return attempt;
    }

    public Player getPlayer() {
        return player;
    }
}
