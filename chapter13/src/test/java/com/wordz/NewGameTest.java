package com.wordz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NewGameTest {

    @Mock
    private GameRepository gameRepository;
    @Mock
    private WordRepository wordRepository;
    @Mock
    private RandomNumbers randomNumbers;
    @InjectMocks
    private Wordz wordz;

    @Test
    void selectRandomWord() {

        givenWordToSelect("ABCDE");

        var player = new Player();
        wordz.newGame(player);

        var game = getGameInRepository();

        assertThat(game.getWord())
                .isEqualTo("ABCDE");
    }

    private void givenWordToSelect(String wordToSelect) {

        int wordNumber = 2;

        when(randomNumbers.next(anyInt()))
                .thenReturn(wordNumber);
        when(wordRepository.fetchWordByNumber(wordNumber))
                .thenReturn(wordToSelect);
    }

    @Test
    void startNewGame() {

        givenWordToSelect("ARISE");

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
