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

    public GuessResult assess(Player player, String guess) {

        var game = gameRepository.fetchForPlayer(player);
        if (game.isGameOver()) {
            return GuessResult.ERROR;
        }

        Score score = game.attempt(guess);
        if (score.allCorrect()) {
            return new GuessResult(score, true, false);
        }

        gameRepository.update(game);

        return new GuessResult(score, game.hasNoRemainingGuesses(), false);
    }
}
