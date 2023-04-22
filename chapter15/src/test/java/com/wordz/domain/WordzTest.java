package com.wordz.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordzTest {

    @Test
    void oneIncorrectLetter() {
        var word = new Word("A");
        var score = word.guess("Z");
        var result = score.letter(0);
        assertScoreForLetter(score, 0, Letter.INCORRECT);
    }

    @Test
    void oneCorrectLetter() {
        var word = new Word("A");
        var score = word.guess("A");
        assertScoreForLetter(score, 0, Letter.CORRECT);
    }

    private static void assertScoreForLetter(Score score, int position, Letter expected) {
        assertThat(score.letter(position)).isEqualTo(expected);
    }
}
