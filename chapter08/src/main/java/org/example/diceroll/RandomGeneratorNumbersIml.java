package org.example.diceroll;

import java.util.random.RandomGenerator;

public class RandomGeneratorNumbersIml implements RandomNumbers {

    private final RandomGenerator rnd = RandomGenerator.getDefault();

    public int nextInt(int upperBoundExclusive) {
        return rnd.nextInt(upperBoundExclusive);
    }
}
