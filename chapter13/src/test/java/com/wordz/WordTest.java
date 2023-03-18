package com.wordz;

import org.junit.jupiter.api.Test;

import static com.wordz.Letter.*;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class WordTest {

    @Test
    void oneIncorrectLetter() {

        var word = new Word("A");
        var score = word.guess("Z");

        assertScoreForGuess(score, INCORRECT);
    }

    @Test
    void oneCorrectLetter() {

        var word = new Word("A");
        var score = word.guess("A");

        assertScoreForGuess(score, CORRECT);
    }

    @Test
    void secondLetterWrongPosition() {

        var word = new Word("AR");
        var score = word.guess("ZA");

        assertScoreForGuess(score, PART_CORRECT);
    }

    @Test
    void allScoreCombination() {

        var word = new Word("ARI");
        var score = word.guess("ZAI");

        assertScoreForGuess(score, INCORRECT,
                PART_CORRECT,
                CORRECT);
    }

    private void assertScoreForGuess(Score score, Letter... expected) {

        for (int position = 0; position < expected.length; position++) {

            assertThat(score.letter(position)).isEqualTo(expected[position]);
        }
    }
}
