package com.wordz;

public class Wordz {

    private final WordSelection wordSelection;
    private final GameRepository gameRepository;

    public Wordz(GameRepository gameRepository, WordRepository wordRepository, RandomNumbers randomNumbers) {
        this.gameRepository = gameRepository;
        this.wordSelection = new WordSelection(wordRepository, randomNumbers);
    }

    public void newGame(Player player) {

        var word = wordSelection.choseRandomWord();

        var game = new Game(player, word, 0, false);

        gameRepository.create(game);
    }

    public GuessResult access(Player player, String guess) {
        return null;
    }
}
