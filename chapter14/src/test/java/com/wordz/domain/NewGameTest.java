package com.wordz.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NewGameTest {

    private final Player PLAYER = new Player();
    @Mock
    private WordRepository wordRepository;
    @Mock
    private RandomNumber random;
    @Mock
    private GameRepository gameRepository;
    @InjectMocks
    private Wordz wordz;

    @Test
    void selectsRandomWord() {

        givenWordToSelect("ABCDE");

        Player player = new Player();
        wordz.newGame(player);

        var game = getGameInRepository();

        assertThat(game.getWord()).isEqualTo("ABCDE");
    }

    private void givenWordToSelect(String wordToSelect) {
        int wordNumber = 2;

        when(random.next(anyInt()))
                .thenReturn(wordNumber);
        when(wordRepository.fetchWordByNumber(wordNumber))
                .thenReturn(wordToSelect);
    }

    @Test
    void startNewGame() {

        givenWordToSelect("ARISE");

        wordz.newGame(PLAYER);

        Game game = getGameInRepository();

        assertThat(game.getWord()).isEqualTo("ARISE");
        assertThat(game.getAttemptNumber()).isZero();
        assertThat(game.getPlayer()).isSameAs(PLAYER);
    }

    private Game getGameInRepository() {
        var gameArgument = ArgumentCaptor.forClass(Game.class);
        verify(gameRepository).create(gameArgument.capture());

        return gameArgument.getValue();
    }
}
