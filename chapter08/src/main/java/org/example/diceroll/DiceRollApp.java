package org.example.diceroll;

public class DiceRollApp {

    public static void main(String[] args) {

        new DiceRollApp().run();
    }

    private void run() {

        var rnd = new RandomGeneratorNumbersIml();
        var diceRoll = new DiceRoll(rnd);
        System.out.println(diceRoll.asText());
    }
}
