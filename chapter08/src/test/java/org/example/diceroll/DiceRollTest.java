package org.example.diceroll;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class DiceRollTest {

    @Test
    void getText() {
        var stub = new StubRandomNumbers();
        var diceRoll = new DiceRoll(stub);
        var text = diceRoll.asText();
        assertThat(text).isEqualTo("You rolled a 6");
    }

}