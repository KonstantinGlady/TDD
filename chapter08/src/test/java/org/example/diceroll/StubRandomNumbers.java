package org.example.diceroll;

public class StubRandomNumbers implements RandomNumbers {

    @Override
    public int nextInt(int upperBoundExclusive) {
        return 5;
    }
}
