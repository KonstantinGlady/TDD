package com.wordz.domain;

public class Wordz {

    private final GameRepository gameRepository;
    private final WordSelection wordSelection;

    public Wordz(GameRepository gameRepository, WordRepository wr, RandomNumber rn) {
        this.gameRepository = gameRepository;
        this.wordSelection = new WordSelection(wr, rn);
    }

    public void newGame(Player player) {
        var word = wordSelection.choseRandomWord();
        var game = new Game(player, word, 0);
        gameRepository.create(game);
    }
}
