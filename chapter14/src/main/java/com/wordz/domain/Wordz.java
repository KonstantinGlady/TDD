package com.wordz.domain;

public class Wordz {
    private final GameRepository gameRepository;
    private final WordSelection wordSelection;

    public Wordz(GameRepository gameRepository, WordRepository wordRepository, RandomNumber rnd) {

        this.gameRepository = gameRepository;
        this.wordSelection = new WordSelection(wordRepository, rnd);
    }

    public void newGame(Player player) {

        var game = new Game(player, "ARISE", 0);
        gameRepository.create(game);
    }
}
