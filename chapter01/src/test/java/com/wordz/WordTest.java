package com.wordz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class WordTest {

    @Test
    void oneIncorrectWord() {

        var word = new Word("A");
        var score = word.guess("Z");
        var result = score.letter(0);
        assertThat(result).isEqualTo(Letter.INCORRECT);
    }
}
