package com.ginsan;

public class Chance {

    private float fraction;

    public Chance(float fraction) {
        if (fraction > 1 || fraction < 0) {
            throw new IllegalArgumentException("fraction must between 0 and 1(includes 0 and 1)");
        }
        this.fraction = fraction;
    }

    public Chance not() {
        return new Chance(1 - this.fraction);
    }

    public Chance and(Chance chance) {
        return new Chance(this.fraction * chance.fraction);
    }

    public Chance or(Chance chanceE2) {
        return this.not().and(chanceE2.not()).not();
    }
}
