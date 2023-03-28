package com.wordz;

public interface GameRepository {
    void create(Game game);

    Game fetchForPlayer(Player player);

    void update(Game game);
}
