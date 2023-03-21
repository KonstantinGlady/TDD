package com.wordz;

public class Wordz {


    private final GameRepository gameRepository;

    public Wordz(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void newGame(Player player) {

        var game = new Game(player, "ARISE", 0);

        gameRepository.create(game);
    }
}
