package com.wordz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class NewGameTest {

    @Mock
    private GameRepository gameRepository;
    @InjectMocks
    private Wordz wordz;

    @Test
    void startNewGame() {

        var player = new Player();
        wordz.newGame(player);

        Game game = getGameInRepository();

        assertThat(game.getWord())
                .isEqualTo("ARISE");
        assertThat(game.getAttemptNumbers())
                .isZero();
        assertThat(game.getPlayer())
                .isSameAs(player);
    }

    private Game getGameInRepository() {

        var gameArgument = ArgumentCaptor.forClass(Game.class);
        verify(gameRepository)
                .create(gameArgument.capture());

        return gameArgument.getValue();
    }
}
