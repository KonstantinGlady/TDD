package com.wordz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GuessTest {
    private static final Player PLAYER = new Player();
    private static final String CORRECT_WORD = "ARISE";
    private static final String WRONG_WORD = "RXXXX";

    @Mock
    private GameRepository gameRepository;
    @InjectMocks
    private Wordz wordz;

    @Test
    void recordsGameOverOnCorrectGuess() {
        givenGameInRepository(Game.create(PLAYER, CORRECT_WORD));
        wordz.assess(PLAYER, CORRECT_WORD);
        var game = getUpdatedGameInRepository();

        assertThat(game.isGameOver()).isTrue();
    }

    @Test
    void rejectsGuessAfterGameOver() {
        var game = Game.create(PLAYER, CORRECT_WORD);
        game.end();
        givenGameInRepository(game);
        GuessResult result = wordz.assess(PLAYER, WRONG_WORD);

        assertThat(result.isError()).isTrue();
    }

    @Test
    void gameOverOnTooManyIncorrectGuesses() {
        int maximumGuesses = 5;
        givenGameInRepository(Game.create(PLAYER, CORRECT_WORD, maximumGuesses - 1));
        GuessResult result = wordz.assess(PLAYER, WRONG_WORD);

        assertThat(result.isGameOver()).isTrue();
    }

    @Test
    void reportsGameOverOnCorrectGuess() {
        Player player = new Player();
        var game = new Game(player, "ARISE", 0, false);
        when(gameRepository.fetchForPlayer(player))
                .thenReturn(game);

        var guess = "ARISE";
        GuessResult result = wordz.assess(player, guess);

        assertThat(result.isGameOver()).isTrue();
    }

    @Test
    void returnScoreForGuess() {
        givenGameInRepository(Game.create(PLAYER, CORRECT_WORD, 1));
        GuessResult result = wordz.assess(PLAYER, WRONG_WORD);
        Letter firstLetter = result.score().letter(0);

        assertThat(firstLetter)
                .isEqualTo(Letter.PART_CORRECT);
    }

    @Test
    void updateAttemptNumber() {
        givenGameInRepository(Game.create(PLAYER, CORRECT_WORD));
        wordz.assess(PLAYER, WRONG_WORD);
        var game = getUpdatedGameInRepository();

        assertThat(game.getAttemptNumber()).isEqualTo(1);
    }

    private Game getUpdatedGameInRepository() {
        ArgumentCaptor<Game> argument = ArgumentCaptor.forClass(Game.class);
        verify(gameRepository).update(argument.capture());

        return argument.getValue();
    }

    private void givenGameInRepository(Game game) {
        when(gameRepository.fetchForPlayer(PLAYER)).thenReturn(game);
    }
}
