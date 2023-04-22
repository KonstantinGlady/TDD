package com.wordz.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordzTest {

    @Test
    void oneIncorrectLetter() {
        var word = new Word("A");
        var score = word.guess("Z");
        var result = score.letter(0);
        assertThat(result).isEqualTo(Letter.INCORRECT);
    }
}