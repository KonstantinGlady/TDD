package com.wordz;

public class Game {
    private final Player player;
    private final String word;
    private final int attempt;

    public Game(Player player, String word, int attempt, boolean b) {

        this.player = player;
        this.word = word;
        this.attempt = attempt;
    }

    public static Game create(Player player, String correctWord) {
        return new Game(player, correctWord, 0, false);
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
