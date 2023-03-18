package com.wordz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WordTest {

    @Test
    void oneIncorrectLetter() {

        var word = new Word("A");
        var score = word.guess("Z");
        var result = score.letter(0);

        assertThat(result).isEqualTo(Letter.INCORRECT);
    }

    @Test
    void oneCorrectLetter() {

        var word = new Word("A");
        var score = word.guess("A");

        assertThat(score.letter(0)).isEqualTo(Letter.CORRECT);
    }
}