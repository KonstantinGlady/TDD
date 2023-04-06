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
        var game = new Game(player, word, 0);
        gameRepository.create(game);
    }

    public GuessResult assess(Player player, String guess) {

        var game = gameRepository.fetchForPlayer(player);
        Score score = game.attempt(guess);

        if (score.allCorrect()) {
            return new GuessResult(score, true);
        }
        gameRepository.update(game);

        return new GuessResult(score, false);
    }

}
