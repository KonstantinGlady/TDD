package com.wordz;

import org.junit.jupiter.api.Test;

import static com.wordz.Letter.*;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class WordTest {

    @Test
    void oneIncorrectLetter() {

        var word = new Word("A");
        var score = word.guess("Z");

        assertScoreForLetter(score, 0, INCORRECT);
    }

    @Test
    void oneCorrectLetter() {

        var word = new Word("A");
        var score = word.guess("A");

        assertScoreForLetter(score, 0, CORRECT);
    }

    @Test
    void secondLetterWrongPosition() {

        var word = new Word("AR");
        var score = word.guess("ZA");

        assertScoreForLetter(score, 1, PART_CORRECT);
    }

    @Test
    void allScoreCombination() {

        var word = new Word("ARI");
        var score = word.guess("ZAI");

        assertScoreForLetter(score, 0, INCORRECT);
        assertScoreForLetter(score, 1, PART_CORRECT);
        assertScoreForLetter(score, 2, CORRECT);
    }

    private void assertScoreForLetter(Score score, int position, Letter expected) {

        assertThat(score.letter(position)).isEqualTo(expected);
    }
}
