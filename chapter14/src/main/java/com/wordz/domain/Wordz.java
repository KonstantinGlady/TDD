package com.wordz.domain;

public class Wordz {
    private final GameRepository gameRepository;
    private final WordSelection wordSelection;

    public Wordz(GameRepository gameRepository, WordRepository wordRepository, RandomNumber rnd) {
        this.gameRepository = gameRepository;
        this.wordSelection = new WordSelection(wordRepository, rnd);
    }

    public void newGame(Player player) {
        var word = wordSelection.chooseRandomWord();
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
