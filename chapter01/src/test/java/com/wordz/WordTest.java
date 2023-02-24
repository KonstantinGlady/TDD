package com.wordz;

import org.assertj.core.api.AbstractComparableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class WordTest {

    @Test
    void oneIncorrectWord() {

        var word = new Word("A");
        var score = word.guess("Z");

        assertScoreForLetter(score, 0, Letter.INCORRECT);
    }

    @Test
    void oneCorrectLetter() {

        var word = new Word("A");
        var score = word.guess("A");

        assertScoreForLetter(score, 0, Letter.CORRECT);
    }

    private void assertScoreForLetter(Score score, int position, Letter expected) {
        assertThat(score.letter(position)).isEqualTo(expected);
    }
}
