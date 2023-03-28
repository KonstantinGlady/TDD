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

        game.incrementAttemptNumber();
        gameRepository.update(game);

        var target = new Word(game.getWord());
        var score = target.guess(guess);

        return new GuessResult(score, false);
    }
}
