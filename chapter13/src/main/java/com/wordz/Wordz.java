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
        gameRepository.create(Game.create(player, word));
    }

    public GuessResult assess(Player player, String guess) {
        var game = gameRepository.fetchForPlayer(player);

        if (game.isGameOver()) {
            return GuessResult.ERROR;
        }

        Score score = game.attempt(guess);
        gameRepository.update(game);

        return GuessResult.create(score, game.isGameOver());
    }
}
